package com.taca.controller.mobile.login;

import com.taca.common.exception.BusinessException;
import com.taca.action.LoginAction;
import com.taca.common.bean.ResultBean;
import com.taca.common.constants.IMResp;
import com.taca.common.util.UUIDUtil;
import com.taca.controller.mobile.LoginMobileRestController;
import com.taca.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 芳华 on 2017/10/10.
 */
@Controller
@RequestMapping("mobile/rest")
public class LoginRestController {

    private static final Logger log = LoggerFactory.getLogger(LoginMobileRestController.class);
    @Autowired
    private LoginAction loginAction;
    @ResponseBody
    @RequestMapping(value = "randomCode",method = {RequestMethod.GET,RequestMethod.POST})
    public ResultBean getRandomCode(String username, HttpSession httpSession){
        return loginAction.getRandomCode(username,httpSession);
    }

    @ResponseBody
    @RequestMapping(value = "register/vertify",method = {RequestMethod.GET,RequestMethod.POST})
    public ResultBean registerVertify(String username,  String password,  String confirmPassword,  String nickname,  String randomCode, HttpSession httpSession){
        if(httpSession.getAttribute("randomCode")==null)
        {
        	 throw new BusinessException(IMResp.RANDOMCODE_NOT_GET);
        }
    	if(!randomCode.equals(httpSession.getAttribute("randomCode").toString())){
            throw new BusinessException(IMResp.RANDOM_UNCORRECT);
        }
        
        UserInfo userInfo=new UserInfo();
        userInfo.setNickName(nickname);
        userInfo.setUserName(username);
        userInfo.setPassword(password);
        return loginAction.registerVertify(userInfo);
    }
    @ResponseBody
    @RequestMapping(value = "login/vertify",method = {RequestMethod.POST,RequestMethod.GET})
    public ResultBean loginVertify(String username,String password,HttpSession httpSession,HttpServletResponse response){
       return loginAction.loginVertify(username,password,httpSession,response);
    }
}
