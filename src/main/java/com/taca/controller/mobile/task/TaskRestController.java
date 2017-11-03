package com.taca.controller.mobile.task;

import com.taca.action.TaskAction;
import com.taca.common.bean.ResultBean;
import com.taca.common.exception.IMException;
import com.taca.controller.mobile.LoginMobileRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by 芳华 on 2017/9/25.
 */
@Controller
@RequestMapping("mobile/resttask")
public class TaskRestController {

    private static final Logger log = LoggerFactory.getLogger(LoginMobileRestController.class);

    @Autowired
    private TaskAction taskAction;

    @RequestMapping(value = "receiveTask",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ResultBean receiveTask(Long id, HttpSession httpSession) {
        return taskAction.receiveTask(id,httpSession);
    }
}
