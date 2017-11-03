package com.taca.mapper;


import com.taca.model.TransRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransRecordMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TransRecord record);

    int insertSelective(TransRecord record);

    TransRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransRecord record);

    int updateByPrimaryKey(TransRecord record);

    List<TransRecord> QueryTransRecordListById(Long id);

    /**
     * 任务完成情况交易记录
     * @param transRecord
     * @return
     */
    Long insertTask(TransRecord transRecord);

    Integer updateForTaskAudit(TransRecord transRecord);

    Integer updateForShoppingAudit(TransRecord transRecord);
}