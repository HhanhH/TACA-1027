package com.taca.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taca.action.NoticeAction;

import com.taca.common.bean.ResultBean;
import com.taca.common.util.Page;
import com.taca.model.HonorTitle;
import com.taca.model.NoticeInfo;
import com.taca.model.UserInfo;

@Controller
@RequestMapping("admin/notice/ajax")
public class NoticeAdminRestController {

	@Autowired
	private NoticeAction noticeAction;
	
	
	@RequestMapping("active")
	@ResponseBody
	public ResultBean active(Model model,NoticeInfo noticeInfo){
		
		return new ResultBean<>(noticeAction.updateForActive(noticeInfo));
	}
	
	
}
