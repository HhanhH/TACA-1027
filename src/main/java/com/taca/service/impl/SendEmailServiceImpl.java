package com.taca.service.impl;

import com.taca.common.bean.ResultBean;
import com.taca.common.constants.IMResp;
import com.taca.common.exception.BusinessException;
import com.taca.controller.mobile.LoginMobileController;
import com.taca.service.SendEmailService;

import freemarker.template.Template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by 芳华 on 2017/10/10.
 */
@Component("loginService")
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;

    @Value("${spring.mail.username}")
    private String Sender; //读取配置文件中的参数

    private static final Logger log = LoggerFactory.getLogger(LoginMobileController.class);

    @Override
    public ResultBean sendEmail(String title,String content,String receiver) {
    	//创建邮件发送服务器  
    	javaMailSenderImpl.setHost("smtp.163.com");  
    	javaMailSenderImpl.setUsername("m15671641731@163.com");  
    	javaMailSenderImpl.setPassword("hanhong1234");  
        //加认证机制  
        Properties javaMailProperties = new Properties();  
        javaMailProperties.put("mail.smtp.auth", true);   
        javaMailProperties.put("mail.smtp.starttls.enable", true);   
        javaMailProperties.put("mail.smtp.timeout", 5000);  
        javaMailProperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        javaMailProperties.setProperty("mail.smtp.socketFactory.fallback", "false");
        javaMailProperties.setProperty("mail.smtp.port", "465");
        javaMailProperties.setProperty("mail.smtp.socketFactory.port", "465");
        javaMailSenderImpl.setJavaMailProperties(javaMailProperties);  
        MimeMessage message = javaMailSenderImpl.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,false,"utf-8");
            helper = new MimeMessageHelper(message,false,"utf-8");
			helper.setTo(receiver);
			helper.setSubject(title);
			helper.setText(content,true);
        	
			helper.setFrom(Sender, "taca");
		} catch (UnsupportedEncodingException e) {
			 log.info("邮件发送失败",e);
			 throw new BusinessException(IMResp.FAIL);
        }
        catch (MessagingException e){
            log.info("邮件发送失败",e);
            throw new BusinessException(IMResp.FAIL);
        }
        javaMailSenderImpl.send(message);
        return new ResultBean(IMResp.SUCCESS);
    }
    @Override
    public ResultBean sendGroupEmail(String title,String content,String[] receiver) {
    	//创建邮件发送服务器  
    	javaMailSenderImpl.setHost("smtp.163.com");  
    	javaMailSenderImpl.setUsername("m15671641731@163.com");  
    	javaMailSenderImpl.setPassword("hanhong1234");  
        //加认证机制  
        Properties javaMailProperties = new Properties();  
        javaMailProperties.put("mail.smtp.auth", true);   
        javaMailProperties.put("mail.smtp.starttls.enable", true);   
        javaMailProperties.put("mail.smtp.timeout", 5000);  
        javaMailProperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        javaMailProperties.setProperty("mail.smtp.socketFactory.fallback", "false");
        javaMailProperties.setProperty("mail.smtp.port", "465");
        javaMailProperties.setProperty("mail.smtp.socketFactory.port", "465");
        javaMailSenderImpl.setJavaMailProperties(javaMailProperties);  
        MimeMessage message = javaMailSenderImpl.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,false,"utf-8");
            helper.setTo(receiver);
            helper.setSubject(title);
            helper.setText(content,true);
            helper.setFrom(Sender, "taca");
        }
        catch (MessagingException e){
            log.info("邮件发送失败",e);
            throw new BusinessException(IMResp.FAIL);
        }
        catch (Exception e){
        	  log.info("邮件发送失败",e);
              throw new BusinessException(IMResp.FAIL);
        }
        javaMailSenderImpl.send(message);
        return new ResultBean(IMResp.SUCCESS);
    }
    
    
    
}