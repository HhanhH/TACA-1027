package com.taca.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.tools.hat.internal.model.ReachableExcludesImpl;
import com.taca.action.TaskAuditAction;
import com.taca.common.bean.ResultBean;

@Controller
@RequestMapping("admin/audit/ajax")
public class TaskAuditRestController {

	@Autowired
	private TaskAuditAction taskAuditAtion;
	
	@RequestMapping("agree")
	@ResponseBody
	public ResultBean agree(Long id,Long actStarNumber) {
		return new ResultBean<>(taskAuditAtion.auditTaskAgree(id,actStarNumber));
		
	}
	
	@RequestMapping("reject")
	@ResponseBody
	public ResultBean reject(Long id,String reason) {
		return new ResultBean<>(taskAuditAtion.auditTaskReject(id, reason));
		
	}
}
