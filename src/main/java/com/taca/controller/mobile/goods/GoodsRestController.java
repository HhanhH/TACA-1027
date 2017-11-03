package com.taca.controller.mobile.goods;

import com.taca.action.GoodsAction;
import com.taca.common.bean.ResultBean;
import com.taca.controller.mobile.LoginMobileController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by 芳华 on 2017/9/27.
 */
@Controller
@RequestMapping("mobile/restgoods")
public class GoodsRestController {

    private static final Logger log = LoggerFactory.getLogger(LoginMobileController.class);

    @Autowired
    private GoodsAction goodsAction;

    @ResponseBody
    @RequestMapping(value = "exchangeGoods",method = {RequestMethod.GET,RequestMethod.POST})
    public ResultBean exchangeGoods(Long id, HttpSession httpSession){
        return goodsAction.exchangeGoods(id,httpSession);
    }
}
