package com.taca.action;

import com.taca.model.HonorTitle;
import com.taca.model.UserInfo;
import com.taca.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by asus on 2017/9/25.
 */
@Component
public class QueryRankAction {
    @Autowired
    private RankService rankService;

    public List<UserInfo> queryHonorTitleList(){
        return rankService.queryHonorList();
    }
    public List<UserInfo> queryHonorMonth(){
        return rankService.queryHonorMonth();
    }
    public List<UserInfo> queryHonorMonths(){
        return rankService.queryHonorMonths();
    }
}
