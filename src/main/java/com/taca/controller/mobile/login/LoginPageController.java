package com.taca.controller.mobile.login;

import com.taca.job.TimerJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 芳华 on 2017/9/29.
 */
@Controller
@RequestMapping("mobile")
public class LoginPageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimerJob.class);

   /* @Autowired
    private LoginAction loginAction;*/

    @RequestMapping(value = "login",method = {RequestMethod.POST,RequestMethod.GET})
    public String login() {
        return "mobile/login";
    }
    @RequestMapping(value = "register",method = {RequestMethod.POST,RequestMethod.GET})
    public String register(){
        return "mobile/register";
    }
}
