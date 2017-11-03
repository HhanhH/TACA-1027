package com.taca.controller.mobile.userinfo;

import com.taca.action.UserInfoAction;
import com.taca.controller.mobile.LoginMobileController;
import com.taca.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by 芳华 on 2017/9/27.
 */
@Controller
@RequestMapping("mobile/userinfo")
public class UserInfoPageController {

    private static final Logger log = LoggerFactory.getLogger(LoginMobileController.class);

    @Autowired
    private UserInfoAction userInfoAction;

    @RequestMapping(value = "UM",method = {RequestMethod.GET,RequestMethod.POST})
    public String getUserInfoByUM(Model model, HttpSession httpSession){
        String UM=(String)httpSession.getAttribute("username");
        UserInfo userInfo=userInfoAction.getUserInfoByUM(UM);
        model.addAttribute("userInfo",userInfo);
        return "mobile/UserInfo";
    }
    
    @RequestMapping("changePwd")
    public String changPwd(Model model, HttpSession httpSession){
    	 String UM=(String)httpSession.getAttribute("username");
         UserInfo userInfo=userInfoAction.getUserInfoByUM(UM);
         model.addAttribute("userInfo",userInfo);
         return "mobile/changePwd";
    }
}
