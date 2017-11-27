package com.taca.busservice;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.taca.action.TaskAuditAction;
import com.taca.common.constants.AdminConstants;
import com.taca.common.constants.IMResp;
import com.taca.common.enumstatus.SubmissionsStatus;
import com.taca.common.enumstatus.TaskStatus;
import com.taca.common.enumstatus.TransStatus;
import com.taca.common.exception.BusinessException;
import com.taca.mapper.*;
import com.taca.model.*;
import com.taca.service.HonorTitleService;
import com.taca.service.SendEmailService;

import freemarker.template.Template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.taca.mapper.ReceiveTaskMapper;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;


@Component("auditTaskBusService")
public class AuditTaskBusService{

	@Autowired
	private AuditTaskMapper auditTaskMapper;
	
	@Autowired
	private ReceiveTaskMapper reciveTaskMapper;
	
	@Autowired
	private SubmissionsMapper submissionsMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private TransRecordMapper transRecordMapper;
	
	@Autowired
	private HonorTitleMapper honorTitleMapper;
	@Autowired
	private SendEmailService sendEmailService;
	

	@Autowired
	private TaskInfoMapper taskInfoMapper;

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	private static final Logger log = LoggerFactory.getLogger(TaskAuditAction.class);


	@Transactional
	public Integer updateForReject(Long id,final String reason) {
		final String userName = reciveTaskMapper.getUserNameByReceiveId(id);
		
		Integer count = submissionsMapper.getCountByReceiveId(id);
		
		Date date = new Date();
		ReceiveTask reciveTask = new ReceiveTask();
		reciveTask =reciveTaskMapper.getById(id);
		
		reciveTask.setUpdateTime(date);
		if(!count.equals(AdminConstants.TASK_SUBMIT_COUNT)){
			//count=1，第一次审核拒绝，任务状态置为进行中，还可以进行第二次提交
			reciveTask.setStatus(TaskStatus.PROCEEDING.name());
		}else{
			//count=2，第二次审核拒绝，任务置为结束，更新任务库存+1
			TaskInfo taskInfo = taskInfoMapper.selectByPrimaryKey(reciveTask.getTaskId());
			taskInfo.setUpdateTime(new Date());
			taskInfo.setAvailableStock(taskInfo.getAvailableStock()+1);
			taskInfoMapper.updateCountById(taskInfo);
			
			reciveTask.setActStarNumber(0L);
			reciveTask.setFinishedTime(date);
			reciveTask.setStatus(TaskStatus.FINISHED.name());
		}
		reciveTask.setUpdateTime(new Date());
		reciveTaskMapper.audit(reciveTask);
		
		
		
		Submissions submissions = new Submissions();
		submissions.setReceiveTaskId(id);
		submissions.setStatus(SubmissionsStatus.REJECT.name());
		submissions.setUpdateTime(date);
		submissions.setMessage(reason);
		
		
		submissionsMapper.updateForReject(submissions);
		
		Long trandId = reciveTaskMapper.getTransIdByReceiveId(reciveTask.getId());
		TransRecord transRecord = new TransRecord();
		transRecord.setId(trandId);
		transRecord.setFinishedTime(new Date());
		transRecord.setUpdateTime(transRecord.getFinishedTime());
		transRecord.setStatus(TransStatus.FAIL.name());
		transRecordMapper.updateForTaskAudit(transRecord);
		//send email
		final Long reciveTaskId=reciveTask.getId();
		 new Thread() {
			public void run() {
				ReceiveTask receiveTask = reciveTaskMapper.getById(reciveTaskId);
				String title="任务审核拒绝";
				String receiver=userName+"@pingan.com.cn";
				//读取邮件模板
				Template template=null;
				String content="";
				try {
					template= freeMarkerConfigurer.getConfiguration().getTemplate("/emailTemplates/taskAuditFail.ftl");
					Map<String,Object> map=new HashMap<>();
					map.put("reason", reason);
					map.put("name", receiveTask.getName());
					map.put("content", receiveTask.getContent());
					content = FreeMarkerTemplateUtils.processTemplateIntoString(template,map);
				}
				catch (Exception e){
					log.info("邮件读取出错",e);
					throw new BusinessException(IMResp.TEMPLATE_LOAD_ERROR);
				}
				log.info("解析结果："+content);
				sendEmailService.sendEmail(title,content,receiver);
			}
		}.start();
		return 1;
		
	}


	@Transactional
	public Integer updateForAgree(ReceiveTask reciveTask,Submissions submissions) {
		reciveTaskMapper.audit(reciveTask);
		submissionsMapper.updateForAgree(submissions);
		//变更交易状态
		Long trandId = reciveTaskMapper.getTransIdByReceiveId(reciveTask.getId());
		TransRecord transRecord = new TransRecord();
		transRecord.setId(trandId);
		transRecord.setFinishedTime(new Date());
		transRecord.setUpdateTime(transRecord.getFinishedTime());
		transRecord.setStarNumber(reciveTask.getActStarNumber());
		transRecord.setStatus(TransStatus.FINISHED.toString());
		transRecordMapper.updateForTaskAudit(transRecord);

		//变更用户星点数
		final String userName = reciveTaskMapper.getUserNameByReceiveId(reciveTask.getId());
		UserInfo user = userInfoMapper.selectByUserName(userName);
		user.setAvailableStar(user.getAvailableStar()+reciveTask.getActStarNumber());
		user.setHistoryStar(user.getHistoryStar()+reciveTask.getActStarNumber());
		user.setUpdateTime(new Date());


		List<HonorTitle> list = honorTitleMapper.getList();
		Long star = user.getHistoryStar();
		String title = null;
		for(HonorTitle honorTitle:list){
			if(star>honorTitle.getStarNumber()){
				title = honorTitle.getTitle();
				continue;
			}else if (star==honorTitle.getStarNumber()) {
				user.setHonorTitle(honorTitle.getTitle());
				break;
			}else{
				user.setHonorTitle(title);
				break;
			}
		}
		user.setHonorTitle(title);
		userInfoMapper.updateForTaskAudit(user);
		//send email
		
		final Long reciveTaskId=reciveTask.getId();
		//读取邮件模板
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				ReceiveTask receiveTask = reciveTaskMapper.getById(reciveTaskId);
				String etitle="任务审核通过";
				String receiver=userName+"@pingan.com.cn";
				String content;
				try {
					Template template= freeMarkerConfigurer.getConfiguration().getTemplate("/emailTemplates/taskAuditSuccess.ftl");
					Map map=new HashMap();
					map.put("actStar",receiveTask.getActStarNumber());
					map.put("name", receiveTask.getName());
					map.put("content", receiveTask.getContent());
					 content = FreeMarkerTemplateUtils.processTemplateIntoString(template,map);
				}
				catch (Exception e){
					log.info("邮件读取出错",e);
					throw new BusinessException(IMResp.TEMPLATE_LOAD_ERROR);
				}
				log.info("解析结果："+receiveTask.getContent());
				sendEmailService.sendEmail(etitle,content,receiver);
			}
		}
				).start();
	
		
		return (Integer) 1;
	}
}
