package com.taca.service;

import java.util.List;
import java.util.Map;

import com.taca.common.util.Page;
import com.taca.model.Shopping;

public interface ShoppingService {

	Integer countForAudit(Map<String,Object> map);
	List<Shopping> getAuditListByPage(Map<String,Object> map);
	Integer countForHisAudit(Map<String,Object> map);
	List<Shopping> getHisAuditListByPage(Map<String,Object> map);
	Long getTransId(Long id);
	Shopping getById(Long id);
	Integer count();
	String getUMById(Long id);
	
}
