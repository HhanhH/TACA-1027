package com.taca.controller.mobile.notice;

import com.taca.action.NoticeAction;
import com.taca.model.NoticeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 芳华 on 2017/9/28.
 */
@RequestMapping("mobile/notice")
@Controller
public class NoticeController {

    @Autowired
    private NoticeAction noticeAction;

    @RequestMapping(value = "list",method = {RequestMethod.GET,RequestMethod.POST})
    public String getNoticeList(Model model){
        model.addAttribute("noticeList",noticeAction.getNoticeList());
        return "mobile/index";
    }

    @RequestMapping(value = "/{id}",method = {RequestMethod.POST,RequestMethod.GET})
    public String getNoticeById(@PathVariable Long id,Model model){
        NoticeInfo noticeInfo=noticeAction.getById(id);
        model.addAttribute("noticeInfo",noticeInfo);
        return "mobile/noticeDetail";
    }
}
