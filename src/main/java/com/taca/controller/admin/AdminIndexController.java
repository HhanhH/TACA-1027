package com.taca.controller.admin;

import javax.servlet.http.HttpServletRequest;

import com.taca.action.UserInfoAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taca.action.ShoppingAuditAction;
import com.taca.action.TaskAuditAction;

@Controller
@RequestMapping("admin")
public class AdminIndexController {

	@Autowired
	private UserInfoAction userAction;
	@Autowired
	private TaskAuditAction taskAuditAction;
	@Autowired
	private ShoppingAuditAction shoppingAuditAction;
	
	@RequestMapping("index")
	public String index(Model model,HttpServletRequest request){
		Integer userCount = userAction.userCount();
		Integer reciveTaskCount = taskAuditAction.receiveCount();
		Integer shoppingCount = shoppingAuditAction.shoppingCount();
		
		model.addAttribute("userCount", userCount);
		model.addAttribute("reciveTaskCount", reciveTaskCount);
		model.addAttribute("shoppingCount", shoppingCount);
		return "admin/index";
	}
}
