package com.taca.controller.mobile.task;

import com.taca.action.QueryRankAction;
import com.taca.action.QueryTaskListAction;
import com.taca.action.TaskAction;
import com.taca.controller.mobile.LoginMobileController;
import com.taca.model.TaskInfo;
import com.taca.vo.TaskList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by 芳华 on 2017/9/22.
 */
@Controller
@RequestMapping("mobile/task")
public class TaskPageController {

    private static final Logger log = LoggerFactory.getLogger(TaskPageController.class);

    @Autowired
    private TaskAction taskAction;

    @RequestMapping(value = "hot" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String getHotTaskList(Model model){
        List<TaskInfo> taskInfoList=taskAction.getHotTaskList();
        List<String> typeList=taskAction.getTypeList();
        List<Long> starLevelList=taskAction.getStarLevelList();
        log.info(starLevelList.toString());
        model.addAttribute("typeList",typeList);
        model.addAttribute("starLevelList",starLevelList);
        model.addAttribute("taskList",taskInfoList);
        return "mobile/TaskList";
    }
    @RequestMapping(value = "new" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String getNewTaskList(Model model){
        List<TaskInfo> taskInfoList=taskAction.getNewTaskList();
        List<String> typeList=taskAction.getTypeList();
        List<Long> starLevelList=taskAction.getStarLevelList();
        model.addAttribute("typeList",typeList);
        model.addAttribute("starLevelList",starLevelList);
        model.addAttribute("taskList",taskInfoList);
        return "mobile/TaskList";
    }
    @RequestMapping(value = "timeDesc" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String getTaskListByTimeDesc(Model model){
        List<TaskInfo> taskInfoList=taskAction.getTaskListByTimeDesc();
        List<String> typeList=taskAction.getTypeList();
        List<Long> starLevelList=taskAction.getStarLevelList();
        model.addAttribute("typeList",typeList);
        model.addAttribute("starLevelList",starLevelList);
        model.addAttribute("taskList",taskInfoList);
        return "mobile/TaskList";
    }
    @RequestMapping(value = "timeAsc" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String getTaskListByTimeAsc(Model model){
        List<TaskInfo> taskInfoList=taskAction.getTaskListByTimeAsc();
        List<String> typeList=taskAction.getTypeList();
        List<Long> starLevelList=taskAction.getStarLevelList();
        model.addAttribute("typeList",typeList);
        model.addAttribute("starLevelList",starLevelList);
        model.addAttribute("taskList",taskInfoList);
        return "mobile/TaskList";
    }
    @RequestMapping(value = "starNumberDesc" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String getTaskListStarNumberDesc(Model model){
        List<TaskInfo> taskInfoList=taskAction.getTaskListByStarNumberDesc();
        List<String> typeList=taskAction.getTypeList();
        List<Long> starLevelList=taskAction.getStarLevelList();
        model.addAttribute("typeList",typeList);
        model.addAttribute("starLevelList",starLevelList);
        model.addAttribute("taskList",taskInfoList);
        return "mobile/TaskList";
    }
    @RequestMapping(value = "starNumberAsc" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String getTaskListByStarNumberAsc(Model model){
        List<TaskInfo> taskInfoList=taskAction.getTaskListByStarNumberAsc();
        List<String> typeList=taskAction.getTypeList();
        List<Long> starLevelList=taskAction.getStarLevelList();
        model.addAttribute("typeList",typeList);
        model.addAttribute("starLevelList",starLevelList);
        model.addAttribute("taskList",taskInfoList);
        return "mobile/TaskList";
    }
    @RequestMapping(value = "timeLengthDesc" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String getTaskListByTimeLengthDesc(Model model){
        List<TaskInfo> taskInfoList=taskAction.getTaskListByTimeLengthDesc();
        List<String> typeList=taskAction.getTypeList();
        List<Long> starLevelList=taskAction.getStarLevelList();
        model.addAttribute("typeList",typeList);
        model.addAttribute("starLevelList",starLevelList);
        model.addAttribute("taskList",taskInfoList);
        return "mobile/TaskList";
    }
    @RequestMapping(value = "timeLengthAsc" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String getTaskListByTimeLengthAsc(Model model){
        List<TaskInfo> taskInfoList=taskAction.getTaskListByTimeLengthAsc();
        List<String> typeList=taskAction.getTypeList();
        List<Long> starLevelList=taskAction.getStarLevelList();
        model.addAttribute("typeList",typeList);
        model.addAttribute("starLevelList",starLevelList);
        model.addAttribute("taskList",taskInfoList);
        return "mobile/TaskList";
    }
    @RequestMapping(value = "category",method = {RequestMethod.GET,RequestMethod.POST})
    public String getTaskListByCategory(String category,Model model){
        List<TaskInfo> taskInfoList=taskAction.getTaskListByCategory(category);
        List<String> typeList=taskAction.getTypeList();
        List<Long> starLevelList=taskAction.getStarLevelList();
        model.addAttribute("typeList",typeList);
        model.addAttribute("starLevelList",starLevelList);
        model.addAttribute("taskList",taskInfoList);
        return "mobile/TaskList";
    }
    @RequestMapping(value = "starLevel",method = {RequestMethod.GET,RequestMethod.POST})
    public String getTaskListByStarlevel(Long starLevel,Model model){
        List<TaskInfo> taskInfoList=taskAction.getTaskListByStarLevel(starLevel);
        List<String> typeList=taskAction.getTypeList();
        List<Long> starLevelList=taskAction.getStarLevelList();
        model.addAttribute("typeList",typeList);
        model.addAttribute("starLevelList",starLevelList);
        model.addAttribute("taskList",taskInfoList);
        return "mobile/TaskList";
    }
    @RequestMapping(value = "/{id}",method = {RequestMethod.GET,RequestMethod.POST})
    public String getTaskById(Model model,@PathVariable Long id){
        TaskInfo taskInfo=taskAction.getTaskById(id);
        model.addAttribute("taskInfo",taskInfo);
        return "mobile/TaskDetail";
    }
}
