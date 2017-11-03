package com.taca.service;

import com.taca.model.HonorTitle;
import com.taca.model.UserInfo;

import java.util.List;

/**
 * Created by asus on 2017/9/25.
 */
public interface RankService {

    List<UserInfo> queryHonorList();
    List<UserInfo> queryHonorMonth();
    List<UserInfo> queryHonorMonths();
}
