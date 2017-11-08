package com.taca.action;

import com.taca.common.enumstatus.UserStatus;
import com.taca.common.exception.BusinessException;
import com.taca.common.bean.ResultBean;
import com.taca.common.constants.IMResp;
import com.taca.common.util.CookieUtil;
import com.taca.common.util.MD5Util;
import com.taca.common.util.UUIDUtil;
import com.taca.controller.mobile.LoginMobileController;
import com.taca.mapper.HonorTitleMapper;
import com.taca.model.HonorTitle;
import com.taca.model.UserInfo;
import com.taca.service.HonorTitleService;
import com.taca.service.SendEmailService;
import com.taca.service.UserInfoService;

import freemarker.template.Template;

import org.apache.commons.codec.digest.Md5Crypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 芳华 on 2017/10/10.
 */
@Component("loginAction")
public class LoginAction {

    @Autowired
    private SendEmailService sendEmailService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private HonorTitleService honorTitleService;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    private static final Logger log = LoggerFactory.getLogger(LoginMobileController.class);

    public ResultBean getRandomCode(String username, HttpSession httpSession){
        if(username==null||username.equals("")){
            throw new BusinessException(IMResp.USERNAME_IS_NULL);
        }
        if(userInfoService.getByUserName(username)==null){
            throw new BusinessException(IMResp.ACCOUNT_IS_ILLEGAL);
        }
        int randomCode= UUIDUtil.getRandom();
        String title="卓越职场人：验证邮件";
        String receiver=username+"@pingan.com.cn";
        httpSession.setAttribute("randomCode",randomCode);
        //读取邮件模板
        Template template=null;
        String content="";
        try {
            template= freeMarkerConfigurer.getConfiguration().getTemplate("/emailTemplates/randomCode.ftl");
            Map map=new HashMap();
            map.put("randomCode",randomCode+"");
            content = FreeMarkerTemplateUtils.processTemplateIntoString(template,map);
        }
        catch (Exception e){
            log.info("邮件读取出错",e);
            throw new BusinessException(IMResp.TEMPLATE_LOAD_ERROR);
        }
        return sendEmailService.sendEmail(title,content,receiver);
    }

    public ResultBean registerVertify(UserInfo userInfo){
        UserInfo user=userInfoService.getByUserName(userInfo.getUserName());
        if(user.getStatus()!=null&&user.getStatus().equals(UserStatus.ACTIVE.toString())){
            throw new BusinessException(IMResp.HAD_REGISTER);
        }
        if(user==null){
            throw new BusinessException(IMResp.ACCOUNT_IS_ILLEGAL);
        }
        HonorTitle honorTitle=honorTitleService.getMinTitle();
        userInfo.setHonorTitle(honorTitle.getTitle());
        userInfo.setPassword(MD5Util.MD5(userInfo.getPassword()));
        return userInfoService.updateUserInfo(userInfo);
    }

    public ResultBean loginVertify(String username,String password,HttpSession httpSession,HttpServletResponse response) {
        if (username == null || username.equals("") || password == null || password.equals("")) {
            throw new BusinessException(IMResp.FIELD_IS_NULL);
        }
        UserInfo userInfo = userInfoService.getUserInfoByUM(username);
        if (userInfo == null) {
            throw new BusinessException(IMResp.NOT_REGISTER);
        }
        
        
      
        if (!MD5Util.MD5(password).equals(userInfo.getPassword())) {
        	throw new BusinessException(IMResp.PASSWORD_UNCORRECT);
        }
       httpSession.setMaxInactiveInterval(60*30);
       httpSession.setAttribute("username",username);
       return new ResultBean(IMResp.SUCCESS);
    }
    
   
    public static String encryptMD5(byte[] data) throws Exception {  
    	  
        MessageDigest md5 = MessageDigest.getInstance("MD5");  
        md5.update(data);  
        return md5.digest().toString();  
      
    }  
    
    public static void main(String[] args){
    	String str = "123";
    	try {
			System.out.println(MD5Util.MD5(str));
			System.out.println(MD5Util.MD5(str));
			System.out.println(MD5Util.MD5(str));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
