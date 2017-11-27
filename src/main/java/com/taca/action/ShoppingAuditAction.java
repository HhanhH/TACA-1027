package com.taca.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import freemarker.template.Template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taca.common.enumstatus.ShoppingStatus;
import com.taca.common.exception.BusinessException;
import com.taca.common.exception.IMRunTimeException;
import com.taca.service.SendEmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taca.busservice.AuditShoppingBusService;
import com.taca.common.constants.IMResp;
import com.taca.common.util.ExcelUtil;
import com.taca.common.util.Page;
import com.taca.model.Shopping;
import com.taca.service.ShoppingService;
import com.taca.service.UserInfoService;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@Component
public class ShoppingAuditAction {

	@Autowired
	private AuditShoppingBusService auditShoppingBusService;
	
	@Autowired
	private ShoppingService shoppingService;
	
	@Autowired
	private UserInfoService userInfoService;

	public List<Shopping> getAuditListByPage(Map<String,Object> map,Shopping shopping,Page page) {
		shopping.setStatus(ShoppingStatus.PROCEEDING.toString());
		Integer count = 0;
		map.put("shopping", shopping);
		count = shoppingService.countForAudit(map);
		page.setTotalNumber(count);
		page.count();
		List<Shopping> list = null;

		map.put("page", page);

		list = shoppingService.getAuditListByPage(map);
		return list;

	}
	public Integer shoppingCount(){
		return shoppingService.count();
	}

	public List<Shopping> getHistoryAuditListByPage(Map<String,Object> map,Shopping shopping,Page page) {
		Integer count = 0;
		map.put("shopping", shopping);
		count = shoppingService.countForHisAudit(map);
		page.setTotalNumber(count);
		page.count();
		map.put("page", page);
		List<Shopping> list = null;
		list = shoppingService.getHisAuditListByPage(map);
		return list;

	}
	
	public void getHistoryAuditList(Map<String,Object> map,Shopping shopping,HttpServletResponse response) {
		
		map.put("shopping", shopping);
		List<Shopping> list = null;
		list = shoppingService.getHisAuditList(map);
		try {
			ExcelUtil.writeExcelToResponse(ExcelUtil.parseListToWorkbook(list, Shopping.class), "historyAuditShoppig.xlsx", response);
		} catch (IOException e) {
			throw new IMRunTimeException(IMResp.FAIL);
		}

	}
	public Integer auditShoppingReject(Long id,String reason) {
		auditShoppingBusService.updateForReject(id, reason);

		return 1;
	}


	public Integer auditShoppingAgree(Long id) {

		auditShoppingBusService.updateForAgree(id);

		return 1;
	}



}
