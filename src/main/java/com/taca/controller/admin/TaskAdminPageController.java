package com.taca.controller.admin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.taca.model.ReceiveTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taca.action.TaskAction;
import com.taca.common.bean.ResultBean;
import com.taca.common.util.Page;
import com.taca.model.TaskInfo;


@Controller
@RequestMapping("admin/task")
public class TaskAdminPageController {
	
	private static final Logger log = LoggerFactory
			.getLogger(TaskAdminRestController.class);
	@Autowired
	private TaskAction taskAction;

	@RequestMapping(value = "taskList", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String taskList(HttpServletRequest request,Long starProfit1,Long starProfit2,
			String createTime1,String createTime2,
			Model model,TaskInfo taskInfo,Page page) {
		Map<String , Object> map = new HashMap<>();
		map.put("createTime1", createTime1);
		map.put("createTime2", createTime2);
		map.put("starProfit1", starProfit1);
		map.put("starProfit2", starProfit2);
		
		List<TaskInfo> taskInfoList = taskAction.queryTaskList(map,taskInfo,page);
		List<String> categoryList = taskAction.getCategoryList(); 
		
		
		model.addAttribute("taskList", taskInfoList);
		model.addAttribute("page", page);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("createTime1", createTime1);
		model.addAttribute("createTime2", createTime2);
		model.addAttribute("starProfit1", starProfit1);
		model.addAttribute("starProfit2", starProfit2);
		return "admin/taskList";

	}

	@RequestMapping(value = "taskInfo/{id}", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String taskInfo(@PathVariable Long id, Model model) {
		TaskInfo taskInfo = taskAction.queryTaskInfoById(id);
		model.addAttribute("taskInfo", taskInfo);
		return "admin/taskInfo";
	}

	@RequestMapping(value = "addNewTask", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String addNewTask(@RequestParam("file") MultipartFile file,
			TaskInfo taskInfo, Model model, HttpServletRequest request) {

		taskAction.insertNewTask(file, taskInfo, request);
		return "redirect:taskList";
	}

	@RequestMapping(value = "goAddNewTask", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String goAddNewTask() {
		return "admin/addNewTask";
	}
	
	@RequestMapping(value = "goEditTask/{id}", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String goEditTask(@PathVariable Long id,Model model) {
		TaskInfo task=taskAction.queryTaskInfoById(id);
		model.addAttribute("task", task);
		return "admin/editTask";
	}
	
	@RequestMapping("updateTaskInfo")
	public String updateTaskInfo(@RequestParam("file") MultipartFile file,TaskInfo taskInfo){
		
		taskAction.updateTaskInfo(file,taskInfo);
		return "redirect:taskList";
		   
	}

	@RequestMapping(value = "goAddMutexTask", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String goAddMutexTask(Model model) {
		List<TaskInfo> list = taskAction.getTaskListForMutex();
		model.addAttribute("taskList", list);
		return "admin/addMutexTask";
	}



	@RequestMapping(value = "userTaskList", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String goUserTaskList(Model model, ReceiveTask receiveTask, String createTime1,String createTime2,Page page) {
        Map<String, Object> map = new HashMap<>(); 
		map.put("createTime1", createTime1);
		map.put("createTime2", createTime2);
		List<ReceiveTask> rTaskList = taskAction.queryReceiveTaskList(map,receiveTask,page);
		model.addAttribute("reciveTaskList", rTaskList);
		model.addAttribute("page", page);
		model.addAttribute("receiveTask", receiveTask);
		model.addAttribute("createTime1", createTime1);
		model.addAttribute("createTime2", createTime2);
		return "admin/userTaskList";
	}
}
