package com.taca.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taca.common.constants.IMResp;
import com.taca.common.enumstatus.UserStatus;
import com.taca.common.exception.IMRunTimeException;
import com.taca.common.util.Page;
import com.taca.model.GoodsInfo;
import com.taca.model.HonorTitle;
import com.taca.model.UserInfo;
import com.taca.service.HonorTitleService;
import com.taca.service.UserInfoService;

@Component
public class HonorTitleAction {

	
	@Autowired
	private HonorTitleService honorTitleService;
	
	public List<HonorTitle> getListByPage(Page page) {
		
		int count=honorTitleService.count();
		page.setTotalNumber(count);
		page.count();
		List<HonorTitle> list=null;
		list= honorTitleService.getListByPage(page);
		return list;
	}
	
	public Integer addTitle(HonorTitle honorTitle) {
		HonorTitle hTitle = honorTitleService.getHonorTitleByTitle(honorTitle.getTitle());
		if(hTitle !=null ){
			throw new IMRunTimeException(IMResp.DATA_EXISTS);
		}
		
		return honorTitleService.insert(honorTitle);
		
	}
	
	public Integer updateTitle(HonorTitle honorTitle) {
		Date date = new Date();
		honorTitle.setUpdateTime(date);
		
		return honorTitleService.update(honorTitle);
		
	}
	
	public HonorTitle getById(Long id) {
		return honorTitleService.getById(id);
	}
}
