package com.taca.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.tools.hat.internal.model.ReachableExcludesImpl;
import com.taca.action.ShoppingAuditAction;
import com.taca.action.TaskAuditAction;
import com.taca.common.bean.ResultBean;

@Controller
@RequestMapping("admin/shoppingAudit/ajax")
public class ShoppingAuditRestController {

	@Autowired
	private ShoppingAuditAction shoppingAuditAction;
	
	@RequestMapping("agree")
	@ResponseBody
	public ResultBean agree(Long id) {
		return new ResultBean<>(shoppingAuditAction.auditShoppingAgree(id));
		
	}
	
	@RequestMapping("reject")
	@ResponseBody
	public ResultBean reject(Long id,String reason) {
		return new ResultBean<>(shoppingAuditAction.auditShoppingReject(id, reason));
		
	}
}
