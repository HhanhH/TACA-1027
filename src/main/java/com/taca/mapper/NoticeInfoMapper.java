package com.taca.mapper;


import com.taca.model.NoticeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NoticeInfo record);

    int insertSelective(NoticeInfo record);

    NoticeInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoticeInfo record);

    int updateByPrimaryKeyWithBLOBs(NoticeInfo record);

    int updateByPrimaryKey(NoticeInfo record);

    List<NoticeInfo> getNoticeList();

    List<NoticeInfo> getListByPage(Map map);

    Integer count(NoticeInfo noticeInfo);

    Integer countByMap(Map map);

}