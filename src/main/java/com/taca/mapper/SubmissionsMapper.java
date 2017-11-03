package com.taca.mapper;


import java.util.Map;

import com.taca.model.Submissions;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubmissionsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Submissions record);

    int insertSelective(Submissions record);

    Submissions selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Submissions record);

    int updateByPrimaryKey(Submissions record);

    //插入用户反馈信息
    int insertUserBack(Submissions submissions);

    Integer updateForReject(Submissions submissions);

    Integer updateForAgree(Submissions submissions);
    
    Integer getCountByReceiveId(Long id);
    
    Submissions getByReceiveId(Long receiveId);
}