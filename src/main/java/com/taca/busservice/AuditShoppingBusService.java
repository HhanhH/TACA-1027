package com.taca.busservice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.taca.action.ShoppingAuditAction;
import com.taca.common.constants.IMResp;
import com.taca.common.enumstatus.ShoppingStatus;
import com.taca.common.enumstatus.TransStatus;
import com.taca.common.exception.BusinessException;
import com.taca.service.SendEmailService;

import freemarker.template.Template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.taca.mapper.ShoppingMapper;
import com.taca.mapper.SubmissionsMapper;
import com.taca.mapper.TransRecordMapper;
import com.taca.mapper.UserInfoMapper;
import com.taca.model.ReceiveTask;
import com.taca.model.Shopping;
import com.taca.model.Submissions;
import com.taca.model.TransRecord;
import com.taca.model.UserInfo;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;


@Component("auditShoppingBusService")
public class AuditShoppingBusService{

	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private ShoppingMapper shoppingMapper;
	
	@Autowired
	private TransRecordMapper transRecordMapper;


	@Autowired
	private SendEmailService sendEmailService;


	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	private static final Logger log = LoggerFactory.getLogger(ShoppingAuditAction.class);

	@Transactional
	public Integer updateForReject(Long id,String reason) {
		Date date = new Date();
		Shopping shopping = shoppingMapper.selectByPrimaryKey(id);
		shopping.setUpdateTime(date);
		shopping.setStatus(ShoppingStatus.FAIL.toString());
		shopping.setMessage(reason);
		shopping.setFinishTime(date);
		shoppingMapper.updateForAudit(shopping);
		
		TransRecord transRecord = new TransRecord();
		Long transId = shoppingMapper.getTransId(id);
		transRecord.setId(transId);
		transRecord.setFinishedTime(date);
		transRecord.setStatus(TransStatus.FAIL.toString());
		transRecord.setUpdateTime(date);
		transRecordMapper.updateForShoppingAudit(transRecord);
		
		UserInfo userInfo = new UserInfo();
		String userName = shopping.getUsername();
		userInfo = userInfoMapper.selectByUserName(userName);
		userInfo.setAvailableStar(userInfo.getAvailableStar()+shopping.getStarNumber());
		userInfo.setFreezeStar(userInfo.getFreezeStar()-shopping.getStarNumber());
		userInfo.setUpdateTime(date);
		userInfoMapper.updateForShoppingAudit(userInfo);
		
		final Long inlog = id;
		final String reaString = reason;
       new Thread(new Runnable() {
			
			@Override
			public void run() {
		Shopping shopping = shoppingMapper.selectByPrimaryKey(inlog);
		String um = shoppingMapper.getUMById(inlog);
		String title="激励兑换审核失败通知";
		String receiver=um+"@pingan.com.cn";
		//读取邮件模板
		Template template=null;
		String content="";
		try {
			template= freeMarkerConfigurer.getConfiguration().getTemplate("/emailTemplates/shoppingAuditFail.ftl");
			Map map=new HashMap();
			map.put("reason",reaString);
			map.put("name", shopping.getName());
			map.put("content", shopping.getContent());
			content = FreeMarkerTemplateUtils.processTemplateIntoString(template,map);
		}
		catch (Exception e){
			log.info("邮件读取出错",e);
			throw new BusinessException(IMResp.TEMPLATE_LOAD_ERROR);
		}
		log.info("解析结果："+content);
		sendEmailService.sendEmail(title,content,receiver);
		
			}
		}
				).start();
		return 1;
		
	}
	

	@Transactional
	public Integer updateForAgree(Long id) {

		Date date = new Date();
		Shopping shopping = shoppingMapper.selectByPrimaryKey(id);
		shopping.setUpdateTime(date);
		shopping.setStatus(ShoppingStatus.FINISHED.name());
		shopping.setFinishTime(date);
		shoppingMapper.updateForAudit(shopping);
		
		TransRecord transRecord = new TransRecord();
		Long transId = shoppingMapper.getTransId(id);
		transRecord.setId(transId);
		transRecord.setFinishedTime(date);
		transRecord.setStatus(TransStatus.FINISHED.name());
		transRecord.setUpdateTime(date);
		transRecordMapper.updateForShoppingAudit(transRecord);
		
		UserInfo userInfo = new UserInfo();
		String userName = shopping.getUsername();
		userInfo = userInfoMapper.selectByUserName(userName);
		userInfo.setFreezeStar(userInfo.getFreezeStar()-shopping.getStarNumber());
		userInfo.setUpdateTime(date);
		userInfoMapper.updateForShoppingAudit(userInfo);
		
		
		final Long inlog = id;
       new Thread(new Runnable() {
			
			@Override
			public void run() {
		Shopping shopping = shoppingMapper.selectByPrimaryKey(inlog);
		String um = shoppingMapper.getUMById(inlog);
		String title="激励兑换审核成功通知";
		String receiver=um+"@pingan.com.cn";
		//读取邮件模板
		Template template=null;
		String content="";
		try {
			template= freeMarkerConfigurer.getConfiguration().getTemplate("/emailTemplates/shoppingAuditSuccess.ftl");
			Map map=new HashMap();
			map.put("name", shopping.getName());
			map.put("content", shopping.getContent());
			content = FreeMarkerTemplateUtils.processTemplateIntoString(template,map);
		}
		catch (Exception e){
			log.info("邮件读取出错",e);
			throw new BusinessException(IMResp.TEMPLATE_LOAD_ERROR);
		}
		log.info("解析结果："+content);
		sendEmailService.sendEmail(title,content,receiver);
			}
		}
				).start();
		return 1;
	}
}
