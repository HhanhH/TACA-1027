package com.taca.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taca.mapper.AuditTaskMapper;
import com.taca.vo.AuditTask;
import com.taca.service.TaskAuditService;

@Component("taskAuditService")
public class TaskAuditServiceImpl implements TaskAuditService{
	@Autowired
	private AuditTaskMapper auditTaskMapper;
	
	@Override
	public Integer countForAudit(Map<String, Object> map) {
		return auditTaskMapper.countForAudit(map);
	}

	@Override
	public List<AuditTask> getAuditListByPage(Map map) {
		return auditTaskMapper.getAuditList(map);
	}

	@Override
	public Integer countForHisAudit(Map<String,Object> map) {
		return auditTaskMapper.countHis(map);
	}

	@Override
	public List<AuditTask> getHisAuditListByPage(Map map) {
		return auditTaskMapper.getHisAuditList(map);
	}


}
