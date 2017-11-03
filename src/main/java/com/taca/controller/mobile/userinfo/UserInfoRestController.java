package com.taca.controller.mobile.userinfo;

import com.taca.action.UserInfoAction;
import com.taca.common.bean.ResultBean;
import com.taca.common.constants.IMResp;
import com.taca.common.exception.BusinessException;
import com.taca.controller.mobile.LoginMobileController;
import com.taca.model.UserInfo;
import com.taca.service.UserInfoService;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.File;

/**
 * Created by 芳华 on 2017/9/27.
 */
@Controller
@RequestMapping("mobile/restuserinfo")
public class UserInfoRestController{

    private static final Logger log = LoggerFactory.getLogger(LoginMobileController.class);

    @Autowired
    private UserInfoAction userInfoAction;

    @ResponseBody
    @RequestMapping(value = "rename",method = {RequestMethod.GET,RequestMethod.POST})
    public ResultBean updateNickName(Long id,String nickName){
        return userInfoAction.updateNickName(id,nickName);
    }
    @ResponseBody
    @PostMapping(value = "upLoadProfile")
    public ResultBean upLoadProfile(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request,HttpSession httpSession){
       log.info("!!!!!!!!!!!!"+file);
   /*     boolean isMultipart= ServletFileUpload.isMultipartContent(request);
        if(isMultipart){*/
            httpSession.setAttribute("username",httpSession.getAttribute("username"));
            userInfoAction.updateIcon(file,httpSession);
            return new ResultBean();
    /*    }
        else {
            throw new BusinessException(IMResp.FIELD_IS_NULL);
        }*/
    }
    
    @RequestMapping("changePwd")
    @ResponseBody
    public ResultBean uploadPwd(String pwd,String pwdnew,String userName){
    	return new ResultBean<>(userInfoAction.changPwd(pwd, pwdnew, userName));
    }

}
