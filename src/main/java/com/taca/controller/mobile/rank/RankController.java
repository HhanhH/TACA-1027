package com.taca.controller.mobile.rank;

import com.taca.action.QueryRankAction;
import com.taca.model.HonorTitle;
import com.taca.model.TransRecord;
import com.taca.model.UserInfo;
import com.taca.service.RankService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by asus on 2017/9/23.
 */
@Controller
@RequestMapping("mobile/rank")
public class RankController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(RankController.class);
    @Autowired
    private QueryRankAction queryRankAction;

    @RequestMapping("/")
    public String queryHonorTitleList(Model model) {
        List<UserInfo> userInfos = queryRankAction.queryHonorTitleList();
        UserInfo userInfo = userInfos.get(0);
        log.info("test is actioning "+userInfo.getUserName());
        model.addAttribute("userinfos",userInfos);
        return "mobile/Ranking";
    }

    /**
     * 查询月排行榜
     * @param model
     * @return
     */
    @RequestMapping("/detail/month")
    public String queryHonormonth(Model model){
        List<UserInfo> userInfos =  queryRankAction.queryHonorMonth();
        UserInfo userInfo = userInfos.get(0);
        log.info("test is actioning " + userInfo.getUserName());
        model.addAttribute("userinfos", userInfos);
        return "mobile/MonthRanking";
    }

    /**
     * 查询月排行榜
     * @param
     * @param model
     * @return
     */
    @RequestMapping("/detail/month/months")
    public String queryHonorMonths(String months,Model model){
        List<UserInfo> userInfos =  queryRankAction.queryHonorMonths();
        UserInfo userInfo = userInfos.get(0);
        log.info("test is actioning " + userInfo.getUserName());
        model.addAttribute("userinfos", userInfos);
        return "mobile/QuarterRanking";
    }
}
