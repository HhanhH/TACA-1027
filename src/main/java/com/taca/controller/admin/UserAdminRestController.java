package com.taca.controller.admin;

import com.taca.action.UserInfoAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taca.common.bean.ResultBean;
import com.taca.model.UserInfo;

@Controller
@RequestMapping("admin/user/ajax")
public class UserAdminRestController {
	
	@Autowired
	private UserInfoAction userAction;
	
	
	@RequestMapping("active")
	@ResponseBody
	public ResultBean  activeUser(Long id){
		 System.out.println("id=" +id);
		return new ResultBean<>(userAction.activeUser(id));
	}
	
	@PostMapping("upload")
	@ResponseBody
	public ResultBean  importFile(@RequestParam("file") MultipartFile file,Model model){
		
		return new ResultBean<>(userAction.importFile(file));
				
	}
	@RequestMapping("update")
	@ResponseBody
	public ResultBean  update(UserInfo userInfo,Model model){
		
		return new ResultBean<>(userAction.update(userInfo));
				
	}
	
	
	
	
	@PostMapping("addOne")
	@ResponseBody
	public ResultBean addOne(String um,String userNameCn,String groupName,Long groupId){
		UserInfo userInfo = new UserInfo();
		userInfo.setUm(um);
		userInfo.setUserNameCn(userNameCn);
		userInfo.setGroupId(groupId);
		userInfo.setGroupName(groupName);
		return new ResultBean<>(userAction.addOne(userInfo));
	}

}
