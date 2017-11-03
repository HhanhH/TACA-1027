package com.taca.service;

import java.util.List;

import com.taca.common.util.Page;
import com.taca.model.HonorTitle;

public interface HonorTitleService {
	
	Integer count();
	List<HonorTitle> getListByPage(Page page);
	Integer insert(HonorTitle honorTitle);
	HonorTitle getHonorTitleByTitle(String title);
	HonorTitle getById(Long id);
	List<HonorTitle> getList();
	Integer update(HonorTitle honorTitle);
	HonorTitle getMinTitle();
}
