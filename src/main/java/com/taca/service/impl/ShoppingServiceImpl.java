package com.taca.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taca.common.util.Page;
import com.taca.mapper.ShoppingMapper;
import com.taca.model.Shopping;
import com.taca.service.ShoppingService;


@Component("shoppingService")
public class ShoppingServiceImpl implements ShoppingService {

	@Autowired
	private ShoppingMapper shoppingMapper;


	@Override
	public Integer countForAudit(Map<String,Object> map) {
		return shoppingMapper.countForAudit(map);
	}

	@Override
	public List<Shopping> getAuditListByPage(Map<String,Object> map) {

		return shoppingMapper.getListByPage(map);
	}

	@Override
	public Long getTransId(Long id) {
		return shoppingMapper.getTransId(id);
	}

	@Override
	public Shopping getById(Long id) {
		return shoppingMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer countForHisAudit(Map<String,Object> map) {

		return shoppingMapper.countHis(map);
	}

	@Override
	public List<Shopping> getHisAuditListByPage(Map<String,Object> map) {

		return shoppingMapper.getHisListByPage(map);
	}
	
	@Override
	public List<Shopping> getHisAuditList(Map<String,Object> map) {

		return shoppingMapper.getHisList(map);
	}
	@Override
	public Integer count() {
		Shopping shopping = new Shopping();
		shopping.setStatus("FINISHED");
		return shoppingMapper.count(shopping);
	}
	@Override
	public String getUMById(Long id) {

		return shoppingMapper.getUMById(id);
	}
}
