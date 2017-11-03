package com.taca.controller.mobile;

import cn.springboot.model.auth.User;
import com.taca.busservice.ShoppingBusService;
import com.taca.common.bean.ResultBean;
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
@RequestMapping("mobile/rest")
public class LoginMobileRestController {

    private static final Logger log = LoggerFactory.getLogger(LoginMobileRestController.class);

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ShoppingBusService shoppingBusService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ResultBean login(Model model) {
        return new ResultBean();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("userForm") User user, RedirectAttributes redirectAttributes) {
        return null;
    }

    @RequestMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "view/login/login";
    }



}
