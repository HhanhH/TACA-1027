package com.taca.controller.mobile.mytask;

import com.taca.action.QueryRankAction;
import com.taca.action.QueryTaskListAction;
import com.taca.controller.mobile.task.TaskPageController;
import com.taca.vo.TaskList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

/**
 * Created by 芳华 on 2017/10/17.
 */
@Controller
@RequestMapping("mobile/mytask")
public class MyTaskPageController {
	
	

    private static final Logger log = LoggerFactory.getLogger(MyTaskPageController.class);
    @Autowired
    private QueryRankAction queryRankAction;

    @Autowired
    private QueryTaskListAction queryTaskListAction;
    /**
     * 根据用户名查找用户的任务列表
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String selectName(Model model, HttpSession httpSession){
        String username=(String)httpSession.getAttribute("username");
        List<TaskList> myTaskList =  queryTaskListAction.selectUserTask(username);
        model.addAttribute("myTaskList", myTaskList);
        return "mobile/MyTaskList";
    }
    /**
     * 查找用户的任务详情
     * @param user
     * @param taskNum
     * @param model
     * @return
     */
    @RequestMapping("/detail/{user}/{taskNum}")
    public String selectTaskDetail(@PathVariable String user,@PathVariable String taskNum,Model model){
        List<TaskList> myTaskList =  queryTaskListAction.selectUserTask(user);
        TaskList taskList = myTaskList.get(Integer.parseInt(taskNum));
        model.addAttribute("detail", taskList);
        log.info("testDetail is actioning "+user);
        return "mobile/MyTaskDetail";
    }

    /**
     * 提交反馈
     * @param
     * @return
     */
    @RequestMapping(value = "/update/{userName}/{id}",method = RequestMethod.POST)
    public String submitBack(@PathVariable Long id, @PathVariable String userName, @RequestParam(value = "text") String text, @RequestParam(value = "taskId") Long taskId, @RequestParam(value = "file", required = false) MultipartFile[] file){
        int i = 0;
        try {
            i = queryTaskListAction.insertUserBack(text,file,taskId,userName,id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(i!=0){
            return "mobile/BackSuccess";
        }else{
            return "mobile/BackFail";
        }
    }
    
	@RequestMapping("download")
	public String download( String fileAddress,HttpServletResponse response){
		queryTaskListAction.download(fileAddress, response);
		return "";
	}
}
