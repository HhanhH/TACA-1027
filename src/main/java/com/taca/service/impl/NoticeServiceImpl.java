package com.taca.service.impl;

import com.taca.common.util.Page;
import com.taca.mapper.NoticeInfoMapper;
import com.taca.model.NoticeInfo;
import com.taca.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 芳华 on 2017/9/28.
 */
@Component("noticeService")
public class NoticeServiceImpl implements NoticeService{
    @Autowired
    private NoticeInfoMapper noticeInfoMapper;
    @Override
    public List<NoticeInfo> getNoticeList() {
        return noticeInfoMapper.getNoticeList();
    }
    @Override
    public List<NoticeInfo> getListByPage(Map<String, Object> map) {

        return noticeInfoMapper.getListByPage(map);
    }

    @Override
    public Integer countByMap(Map<String, Object> map) {
        return noticeInfoMapper.countByMap(map);
    }

    @Override
    public Integer count(NoticeInfo noticeInfo) {
        return noticeInfoMapper.count(noticeInfo);
    }

    @Override
    public Integer update(NoticeInfo noticeInfo) {
        Date date = new Date();
        noticeInfo.setUpdateTime(date);

        return noticeInfoMapper.updateByPrimaryKeySelective(noticeInfo);
    }

    @Override
    public NoticeInfo getById(Long id) {
        return noticeInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer add(NoticeInfo noticeInfo) {
        Date date = new Date();
        noticeInfo.setCreateTime(date);
        noticeInfo.setUpdateTime(date);
        return noticeInfoMapper.insertSelective(noticeInfo);
    }


}
