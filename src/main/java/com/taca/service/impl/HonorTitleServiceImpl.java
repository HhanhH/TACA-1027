package com.taca.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taca.common.util.Page;
import com.taca.mapper.HonorTitleMapper;
import com.taca.model.HonorTitle;
import com.taca.service.HonorTitleService;

@Component("honorTitleService")
public class HonorTitleServiceImpl implements HonorTitleService {

	
	@Autowired
	HonorTitleMapper honorTitleMapper;
	
	@Override
	public Integer count() {
		return honorTitleMapper.count();
	}

	@Override
	public List<HonorTitle> getListByPage(Page page) {
		return honorTitleMapper.queryListByPage(page);
	}

	@Override
	public Integer insert(HonorTitle honorTitle) {
		Date date = new Date();
		honorTitle.setCreateTime(date);
		honorTitle.setUpdateTime(date);
		return honorTitleMapper.insert(honorTitle);
	}
	@Override
	public List<HonorTitle> getList() {
		return honorTitleMapper.getList();
	}
	@Override
	public HonorTitle getHonorTitleByTitle(String title) {
		return honorTitleMapper.getByTitle(title);
	}

	@Override
	public HonorTitle getById(Long id) {
		return honorTitleMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer update(HonorTitle honorTitle) {
		return honorTitleMapper.updateByPrimaryKey(honorTitle);
	}

	@Override
	public HonorTitle getMinTitle() {
		return honorTitleMapper.getMinTitle();
	}

}
