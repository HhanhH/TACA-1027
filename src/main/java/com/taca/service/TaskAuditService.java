package com.taca.service;

import com.taca.vo.AuditTask;

import java.util.List;
import java.util.Map;

public interface TaskAuditService {

	Integer countForAudit(Map<String, Object> map);
	List<AuditTask> getAuditListByPage(Map map);
	Integer countForHisAudit(Map<String, Object> map);
	List<AuditTask> getHisAuditListByPage(Map map);



}
