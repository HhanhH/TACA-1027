package com.taca.controller.mobile.goods;

import com.taca.action.GoodsAction;
import com.taca.action.QueryTransShopAction;
import com.taca.action.UserInfoAction;
import com.taca.controller.mobile.LoginMobileController;
import com.taca.model.GoodsInfo;
import com.taca.model.Shopping;
import com.taca.model.UserInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * Created by 芳华 on 2017/9/25.
 */
@Controller
@RequestMapping("mobile/goods")
public class GoodsPageController {

    private static final Logger log = LoggerFactory.getLogger(GoodsPageController.class);

    @Autowired
    private GoodsAction goodsAction;
    @Autowired
    private UserInfoAction userInfoAction;
    @Autowired
    private QueryTransShopAction queryTransShopAction;

    @RequestMapping(value = "list",method = {RequestMethod.GET,RequestMethod.POST})
    public String getGoodsList(Model model,HttpSession httpSession){
        List<GoodsInfo> goodsInfoList=goodsAction.getGoodsList();
        UserInfo userInfo=userInfoAction.getUserInfoByUM((String)httpSession.getAttribute("username"));
        model.addAttribute("goodsInfoList",goodsInfoList);
        model.addAttribute("userInfo",userInfo);
        return "mobile/GoodsStore";
    }

    @RequestMapping(value = "/{id}",method = {RequestMethod.GET,RequestMethod.POST})
    public String getGoodsById(Model model,@PathVariable Long id,HttpSession httpSession){
        GoodsInfo goodsInfo=goodsAction.getGoodsById(id);
        UserInfo userInfo=userInfoAction.getUserInfoByUM((String)httpSession.getAttribute("username"));
        model.addAttribute("goodsInfo",goodsInfo);
        model.addAttribute("userInfo",userInfo);
        model.addAttribute("username",(String)httpSession.getAttribute("username"));
        return "mobile/GoodsDetail";
    }
}
