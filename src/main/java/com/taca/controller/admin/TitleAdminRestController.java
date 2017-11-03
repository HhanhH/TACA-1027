package com.taca.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taca.action.HonorTitleAction;
import com.taca.action.UserInfoAction;
import com.taca.common.bean.ResultBean;
import com.taca.common.util.Page;
import com.taca.model.HonorTitle;
import com.taca.model.UserInfo;

@Controller
@RequestMapping("admin/title/ajax")
public class TitleAdminRestController {

	@Autowired
	private HonorTitleAction honorTitleAction;
	
	
	@RequestMapping("add")
	@ResponseBody
	public ResultBean add(HonorTitle honorTitle){
		return new ResultBean<>(honorTitleAction.addTitle(honorTitle));
	}
	@RequestMapping("edit")
	@ResponseBody
	public ResultBean edit(HonorTitle honorTitle){
		return new ResultBean<>(honorTitleAction.updateTitle(honorTitle));
	}
	
}
