package com.taca.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taca.mapper.SubmissionsMapper;
import com.taca.model.Submissions;
import com.taca.service.SubmissionsService;

@Component("submissionsService")
public class SubmissionsServiceImpl implements SubmissionsService{

	@Autowired
	private SubmissionsMapper submissionsMapper;
	@Override
	public Submissions getByReceiveId(Long receiveId) {
		return submissionsMapper.getByReceiveId(receiveId);
	}

}
