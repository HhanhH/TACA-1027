package com.taca.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taca.action.GoodsAction;
import com.taca.common.bean.ResultBean;
import com.taca.model.GoodsInfo;


@Controller
@RequestMapping("admin/goods/ajax")
public class GoodsAdminRestController {

	@Autowired
	private GoodsAction goodsAction;


	   @RequestMapping("changOffAndOn")
	   @ResponseBody
	   public ResultBean changOffAndOn(Long id){
		  
		   return new ResultBean<>(goodsAction.changOffAndOn(id));
		   
	   }

}
