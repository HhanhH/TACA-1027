package com.taca.service.impl;

import com.taca.mapper.HonorTitleMapper;
import com.taca.mapper.UserInfoMapper;
import com.taca.model.HonorTitle;
import com.taca.model.UserInfo;
import com.taca.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by asus on 2017/9/25.
 */
@Service("RankService")
public class RankServiceImpl implements RankService {
    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public List<UserInfo> queryHonorList() {

        return userInfoMapper.queryHonorRanking();
    }

    @Override
    public List<UserInfo> queryHonorMonth() {
        return userInfoMapper.queryHonorMonth();
    }

    @Override
    public List<UserInfo> queryHonorMonths() {
        return userInfoMapper.queryHonorMonths();
    }
}
