package com.taca.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.taca.action.UserInfoAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.taca.common.bean.ResultBean;
import com.taca.common.util.Page;
import com.taca.model.UserInfo;

@Controller
@RequestMapping("admin/user")
public class UserAdminPageController {

	@Autowired
	private UserInfoAction userAction;


	@RequestMapping("list")
	public String getList(Model model,UserInfo userInfo,String createTime1,String createTime2,Page page){
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("createTime1", createTime1);
		map.put("createTime2", createTime2);

		List<UserInfo> list = userAction.getListByPage(map,userInfo, page);
		List<String> groupList = userAction.getGroupNameList();
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("createTime1", createTime1);
		model.addAttribute("createTime2", createTime2);
		model.addAttribute("groupList", groupList);
		return "admin/userList";
	}
	@RequestMapping("groupUser")
	public String getGroupList(Model model,UserInfo userInfo,String createTime1,String createTime2,Page page){
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("createTime1", createTime1);
		map.put("createTime2", createTime2);
		List<UserInfo> list = userAction.getGroupUserListByPage(map,userInfo, page);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("userInfo", userInfo);
		List<String> groupList = userAction.getGroupNameList();
		model.addAttribute("createTime1", createTime1);
		model.addAttribute("createTime2", createTime2);
		model.addAttribute("groupList", groupList);
		return "admin/groupUserList";
	}
	
	@RequestMapping("info/{id}")
	public String getInfo(Model model,@PathVariable Long id){
		UserInfo user = userAction.getUserById(id);
		model.addAttribute("user", user);
		return "admin/userInfo";
	}
	
	@RequestMapping("goUpdate/{id}")
	public String goUpdate(Model model,@PathVariable Long id){
		UserInfo user = userAction.getUserById(id);
		model.addAttribute("user", user);
		return "admin/updateUserBaseInfo";
	}
	@RequestMapping("getArmory")
	public String getUserArmory(Model model,Page page){
		List<UserInfo> list = userAction.getArmoryListByPage(page);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "admin/userArmory";
		
	}
	@RequestMapping("getMonthArmory")
	public String getMonthArmory(Model model,String time1,String time2 ,Page page){
		
		List<UserInfo> list = userAction.getMonthArmoryListByPage(time1,time2, page);
		model.addAttribute("list", list);
		model.addAttribute("time1", time1);
		model.addAttribute("time2", time2);
		model.addAttribute("page", page);
		
		return "admin/userArmory";
		
	}
	
	@RequestMapping("goImportUser")
	public String goImport(){
		return "admin/import";
	}
	
	@RequestMapping("download")
	public void download(HttpServletResponse response){
		userAction.download(response);
	}
	

	
}
