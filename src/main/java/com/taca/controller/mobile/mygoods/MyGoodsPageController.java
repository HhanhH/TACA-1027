package com.taca.controller.mobile.mygoods;

import com.taca.action.QueryTransShopAction;
import com.taca.controller.mobile.goods.GoodsPageController;
import com.taca.model.Shopping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 芳华 on 2017/10/17.
 */
@Controller
@RequestMapping("mobile/mygoods")
public class MyGoodsPageController {

    @Autowired
    private QueryTransShopAction queryTransShopAction;

    private static final Logger log = LoggerFactory.getLogger(MyGoodsPageController.class);

    @RequestMapping("/{userName}")
    public String  queryTransRecordListById(@PathVariable String userName, Model model){
        List<Shopping> transShopRecords =  queryTransShopAction.selectShoppingByName(userName);
        model.addAttribute("transList", transShopRecords);
        return "mobile/MyPrize";
    }
}
