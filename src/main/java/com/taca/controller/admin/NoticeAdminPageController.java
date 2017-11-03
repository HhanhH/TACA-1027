package com.taca.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.taca.action.NoticeAction;
import com.taca.common.util.Page;
import com.taca.model.NoticeInfo;


@Controller
@RequestMapping("admin/notice")
public class NoticeAdminPageController {

	@Autowired
	private NoticeAction noticeAction;
	
	
	@RequestMapping("list")
	public String getList(Model model,NoticeInfo noticeInfo,String createTime1,String createTime2,Page page){
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("createTime1", createTime1);
		map.put("createTime2", createTime2);
		
		List<NoticeInfo> list = noticeAction.getListByPage(map,noticeInfo,page);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("noticeInfo", noticeInfo);
		model.addAttribute("createTime1", createTime1);
		model.addAttribute("createTime2", createTime2);
		return "admin/announcementList";
	}
	
	@RequestMapping("goAdd")
	public String goAdd(){
		return "admin/addNewAnnouncement";
	}
	
	@RequestMapping("edit")
	public String edit(@RequestParam("file") MultipartFile file,NoticeInfo noticeInfo){
		noticeAction.update(file,noticeInfo);
		return "redirect:list";
	}
	
	@RequestMapping("add")
	public String add(@RequestParam("file") MultipartFile file,NoticeInfo noticeInfo){
		noticeAction.add(file,noticeInfo);
		return "redirect:list";
	}
	
	@RequestMapping("goEdit/{id}")
	public String goEdit(Model model,@PathVariable Long  id){
		NoticeInfo noticeInfo = noticeAction.getById(id);
		model.addAttribute("notice", noticeInfo);
		return "admin/editAnnouncement";
	}
}
