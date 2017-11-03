package com.taca.service;

import com.taca.common.bean.ResultBean;

/**
 * Created by 芳华 on 2017/10/10.
 */
public interface SendEmailService {
    ResultBean sendEmail(String title,String content,String receiver);
    ResultBean sendGroupEmail(String title,String content,String[] receiver);
}
