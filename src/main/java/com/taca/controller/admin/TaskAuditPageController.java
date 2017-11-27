package com.taca.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taca.action.TaskAuditAction;
import com.taca.common.util.Page;
import com.taca.vo.AuditTask;
import com.taca.model.Shopping;

@Controller
@RequestMapping("admin/audit")
public class TaskAuditPageController {

	@Autowired
	private TaskAuditAction taskAuditAction;
	
	@RequestMapping("goAudit")
	public String goAudit(Model model,AuditTask auditTask,String createTime1,String createTime2,Page page){
		Map<String , Object> map = new HashMap<>();
		map.put("createTime1", createTime1);
		map.put("createTime2", createTime2);
	
		
		List<AuditTask> list = taskAuditAction.getAuditListByPage(map,auditTask,page);
		List<String> groupNameList = taskAuditAction.getGroupNameList();
		model.addAttribute("auditTask", auditTask);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("groupNameList", groupNameList);
		model.addAttribute("createTime1", createTime1);
		model.addAttribute("createTime2", createTime2);
		return "admin/auditTask";
	}
	
	@RequestMapping("goHistoryAudit")
	public String goHistoryAudit(Model model,AuditTask auditTask,String createTime1,String createTime2,Page page){
		
		Map<String , Object> map = new HashMap<>();
		map.put("createTime1", createTime1);
		map.put("createTime2", createTime2);
		List<AuditTask> list = taskAuditAction.getHistoryAuditListByPage(map,auditTask,page);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("createTime1", createTime1);
		model.addAttribute("createTime2", createTime2);
		return "admin/historyAuditTaskList";
	}
	
	
	@RequestMapping("export")
	@ResponseBody
	public void  export(Model model,AuditTask auditTask,String createTime1,String createTime2,HttpServletResponse response){
		Map<String , Object> map = new HashMap<>();
		map.put("createTime1", createTime1);
		map.put("createTime2", createTime2);
		
		taskAuditAction.export(map, auditTask, response);
		
	}
	
	@RequestMapping("download")
	public String download( String fileAddress,HttpServletResponse response){
		taskAuditAction.download(fileAddress, response);
		return "";
	}
}
