package com.taca.service;

import com.taca.common.util.Page;
import com.taca.model.NoticeInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by 芳华 on 2017/9/28.
 */
public interface NoticeService {
    List<NoticeInfo> getNoticeList();

    List<NoticeInfo> getListByPage(Map<String, Object> map);
    Integer count(NoticeInfo noticeInfo);
    Integer update(NoticeInfo noticeInfo);
    NoticeInfo getById(Long id);
    Integer add(NoticeInfo noticeInfo);
    Integer countByMap(Map<String, Object> map);
}
