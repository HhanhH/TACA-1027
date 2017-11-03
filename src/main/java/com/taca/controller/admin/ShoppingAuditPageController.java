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

import com.sun.tools.classfile.StackMapTable_attribute.same_frame;
import com.taca.action.ShoppingAuditAction;
import com.taca.action.TaskAuditAction;
import com.taca.common.util.Page;
import com.taca.model.Shopping;

@Controller
@RequestMapping("admin/shoppingAudit")
public class ShoppingAuditPageController {

	@Autowired
	private ShoppingAuditAction shoppingAuditAction;
	
	@RequestMapping("goAudit")
	public String goAudit(Model model,Shopping shopping,String createTime1,String createTime2,Page page){
		
		Map<String , Object> map = new HashMap<>();
		map.put("createTime1", createTime1);
		map.put("createTime2", createTime2);
		List<Shopping> list = shoppingAuditAction.getAuditListByPage(map,shopping,page);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("createTime1", createTime1);
		model.addAttribute("createTime2", createTime2);
		return "admin/auditAward";
	}
	
	
	@RequestMapping("goHistoryAudit")
	public String goHistoryAudit(Model model,Shopping shopping,String createTime1,String createTime2,Page page){
		

		Map<String , Object> map = new HashMap<>();
		map.put("createTime1", createTime1);
		map.put("createTime2", createTime2);
		List<Shopping> list = shoppingAuditAction.getHistoryAuditListByPage(map,shopping,page);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("createTime1", createTime1);
		model.addAttribute("createTime2", createTime2);
		return "admin/historyAuditAwardList";
	}
	
}
