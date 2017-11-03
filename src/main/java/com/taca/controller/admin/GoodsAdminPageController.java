package com.taca.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.taca.action.GoodsAction;
import com.taca.common.util.Page;
import com.taca.model.GoodsInfo;


@Controller
@RequestMapping("admin/goods")
public class GoodsAdminPageController {

	
	@Autowired
	private GoodsAction goodsAction;

	@RequestMapping("goAddGoods")
	public String goAdd(HttpServletRequest request){
		   return "admin/addAward";
	} 
	
	@RequestMapping("add")
	public String  addGoods(@RequestParam("file") MultipartFile file,GoodsInfo goodsInfo,HttpServletRequest request){
		Integer count =goodsAction.addGoods(file,goodsInfo);
		return "redirect:list";
	}
	
	@RequestMapping("edit")
	public String  editGoods(@RequestParam("file") MultipartFile file,GoodsInfo goodsInfo,HttpServletRequest request){
		Integer count =goodsAction.editGoods(file, goodsInfo);
		return "redirect:list";
	}
	
	@RequestMapping("list")
	public String getList(Model model,Long starNumber1,Long starNumber2,
			String createTime1,String createTime2,GoodsInfo goodsInfo,Page page,HttpServletRequest request ){
		Map<String , Object> map = new HashMap<>();
		map.put("createTime1", createTime1);
		map.put("createTime2", createTime2);
		map.put("starNumber1", starNumber1);
		map.put("starNumber2", starNumber2);
		List<GoodsInfo> list = goodsAction.queryListByPage(map,goodsInfo, page);
		List<String> categoryList = goodsAction.getCategoryList(); 
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("name", goodsInfo.getName());
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("createTime1", createTime1);
		model.addAttribute("createTime2", createTime2);
		model.addAttribute("starNumber1", starNumber1);
		model.addAttribute("starNumber2", starNumber2);
		return "admin/awardList";
	}
	
	@RequestMapping("info/{id}")
	public String getInfo(Model model,@PathVariable Long id,HttpServletRequest request){
		GoodsInfo goods = goodsAction.getGoodsById(id);
		model.addAttribute("goods", goods);
		return "admin/awardInfo";
	}
	
	@RequestMapping("goEdit/{id}")
	public String goEdit(Model model,@PathVariable Long id,HttpServletRequest request){
		GoodsInfo goods = goodsAction.getGoodsById(id);
		model.addAttribute("goods", goods);
		return "admin/editAwardInfo";
	}
	

}
