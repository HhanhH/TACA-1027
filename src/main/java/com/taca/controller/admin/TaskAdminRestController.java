package com.taca.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taca.action.TaskAction;
import com.taca.common.bean.ResultBean;
import com.taca.model.TaskInfo;
import com.taca.model.TaskMutex;

@Controller
@RequestMapping("admin/task/ajax")
public class TaskAdminRestController {

    private static final Logger log = LoggerFactory.getLogger(TaskAdminRestController.class);
    @Autowired
    private TaskAction taskAction;

   @RequestMapping("changOffAndOn")
   @ResponseBody
   public ResultBean changOffAndOn(Long id){
	   return new ResultBean<>(taskAction.changOffAndOn(id));
	   
   }
  

   

   @RequestMapping("addTaskMutex")
   @ResponseBody
   public ResultBean addTaskMutex(TaskMutex taskMutex){
	   return new ResultBean<>( taskAction.addTaskMutex(taskMutex));
	   
   }

   @RequestMapping("removeMutex")
   @ResponseBody
   public ResultBean removeMutex(Long taskId, Long mutexTaskId){
	   return new ResultBean<>( taskAction.removeMutex(taskId,mutexTaskId));
	   
   }
   
   


}
