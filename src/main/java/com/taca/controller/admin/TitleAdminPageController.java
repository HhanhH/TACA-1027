package com.taca.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taca.action.HonorTitleAction;
import com.taca.action.UserInfoAction;
import com.taca.common.util.Page;
import com.taca.model.HonorTitle;
import com.taca.model.UserInfo;

@Controller
@RequestMapping("admin/title")
public class TitleAdminPageController {

	@Autowired
	private HonorTitleAction honorTitleAction;
	
	
	@RequestMapping("list")
	public String getList(Model model,Page page){
		List<HonorTitle> list = honorTitleAction.getListByPage(page);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "admin/honorTitleList";
	}
	
	@RequestMapping("goAdd")
	public String add(){
		return "admin/addTitle";
	}
	
	@RequestMapping("goEdit/{id}")
	public String goEdit(Model model,@PathVariable Long id){
		HonorTitle honorTitle = honorTitleAction.getById(id);
		model.addAttribute("honorTitle", honorTitle);
		return "admin/editTitle";
	}
}
