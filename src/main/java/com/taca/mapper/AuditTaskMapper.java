package com.taca.mapper;

import java.util.List;
import java.util.Map;

import com.taca.vo.AuditTask;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AuditTaskMapper {
	
	Integer countForAudit(Map map);
	List<AuditTask> getAuditList(Map map);
	Integer countHis(Map map);
	List<AuditTask> getHisAuditList(Map map);

}
