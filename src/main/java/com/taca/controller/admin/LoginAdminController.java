package com.taca.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.springboot.common.constants.Constants;
import cn.springboot.model.auth.User;

import com.taca.busservice.ShoppingBusService;
import com.taca.common.constants.AdminConstants;
import com.taca.model.Admin;
import com.taca.service.UserInfoService;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("admin")
public class LoginAdminController {

    private static final Logger log = LoggerFactory.getLogger(cn.springboot.controller.LoginController.class);
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ShoppingBusService shoppingBusService;

    @RequestMapping(value = "goLogin")
    public String goLogin() {

        return "admin/login";
    }

    @RequestMapping(value = "login")
    public String login(Admin admin,Model model,HttpServletRequest httpServletRequest,HttpSession session) {
    	if(AdminConstants.ADMIN_NAME.equals(admin.getAdminName())&&AdminConstants.PASSWORD.equals(admin.getPassword())){
        	session.setAttribute("admin", admin);
        	session.setMaxInactiveInterval(5 * 60);//设置单位为秒，设置为-1永不过期
        	return "redirect:index";
        }
        else{
        	model.addAttribute("error", "用户名或密码错误");
        	return "admin/login";
        }
    	
    }


    @RequestMapping("loginOut")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("admin");
    	return "redirect:goLogin";
    }



}
