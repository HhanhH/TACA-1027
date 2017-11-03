package com.taca.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.taca.common.exception.BusinessException;
import com.taca.model.ReceiveTask;
import com.taca.service.ReceiveTaskService;
import com.taca.service.SendEmailService;
import com.taca.service.UserInfoService;
import com.taca.common.util.FileToZip;
import  com.taca.common.util.ZipCompress;

import freemarker.template.Template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taca.busservice.AuditTaskBusService;
import com.taca.common.constants.AdminConstants;
import com.taca.common.constants.Constants;
import com.taca.common.constants.IMResp;
import com.taca.common.enumstatus.SubmissionsStatus;
import com.taca.common.enumstatus.TaskStatus;
import com.taca.common.exception.IMRunTimeException;
import com.taca.common.util.Page;
import com.taca.controller.mobile.LoginMobileController;
import com.taca.vo.AuditTask;
import com.taca.model.Submissions;
import com.taca.service.TaskAuditService;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@Component
public class TaskAuditAction {

	@Autowired
	private AuditTaskBusService auditTaskBusService;
	
	@Autowired
	private TaskAuditService taskAuditService;
	
	@Autowired
	private ReceiveTaskService reciveTaskService;
	
	@Autowired
	private UserInfoService userInfoService;

	private static final Logger log = LoggerFactory.getLogger(TaskAuditAction.class);
	
	public List<AuditTask> getAuditListByPage(Map<String, Object> map,AuditTask auditTask,Page page) {
		auditTask.setStatus(TaskStatus.PENDING.name());
		Integer count = 0;
		map.put("auditTask", auditTask);
		count = taskAuditService.countForAudit(map);
		page.setTotalNumber(count);
		page.count();
		List<AuditTask> list = null;
		map.put("page", page);
		list = taskAuditService.getAuditListByPage(map);
		return list;
	
	}

	public Integer auditTaskReject(Long id,String reason) {
		Integer integer = auditTaskBusService.updateForReject(id,reason);


		return integer;
	}

	public Integer auditTaskAgree(Long id,Long actStarNumber) {

		Date date = new Date();
		ReceiveTask reciveTask = new ReceiveTask();
		reciveTask.setId(id);
		reciveTask.setUpdateTime(date);
		reciveTask.setFinishedTime(date);
		reciveTask.setStatus(TaskStatus.FINISHED.name());
		reciveTask.setActStarNumber(actStarNumber);


		Submissions submissions = new Submissions();
		submissions.setReceiveTaskId(id);
		submissions.setStatus(SubmissionsStatus.AGREE.name());
		submissions.setUpdateTime(date);
		Integer integer = auditTaskBusService.updateForAgree(reciveTask,submissions);


		return integer;
	}


	public Integer receiveCount() {
		return reciveTaskService.countReceive();
		
	}
	
	public List<AuditTask> getHistoryAuditListByPage(Map<String, Object> map,AuditTask auditTask ,Page page) {
		Integer count = 0;
		map.put("auditTask", auditTask);
		count = taskAuditService.countForHisAudit(map);
		page.setTotalNumber(count);
		page.count();
		List<AuditTask> list = null;
		map.put("page", page);
		list = taskAuditService.getHisAuditListByPage(map);
		return list;
	
	}
	
	public void download(String fileAddress,HttpServletResponse response) {
		//fileAddress.substring(0,fileAddress.length()-1).replace("/", "\\");  
		    String sourceFilePath = fileAddress.substring(0,fileAddress.length()-1);
	        String zipFilePath = Constants.SUBMIT_PATH.substring(0,Constants.SUBMIT_PATH.length()-1);  
	        String fileName = fileAddress.substring(14, fileAddress.length()-1);  
		   
		  
	        if(!new File(zipFilePath+File.separator+fileName+".zip").exists()){
	        	boolean flag = FileToZip.fileToZip(sourceFilePath, zipFilePath, fileName);  
		        if(flag){  
		          log.info("文件压缩成功!压缩文件名："+fileName);  
		        }else{  
		            log.info("文件压缩失败!");  
		            throw new IMRunTimeException(IMResp.FILE_ZIP_ERROR);
		        }  
	        }
	        // 读到流中
	        InputStream inStream;
			try {
				inStream = new FileInputStream(new File(zipFilePath+File.separator+fileName+".zip"));
			} catch (FileNotFoundException e1) {
				throw new IMRunTimeException(IMResp.FILE_NOT_FOUND);
			}// 文件的存放路径
	        // 设置输出的格式
	        response.reset();
	        response.setContentType("bin");
	        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + ".zip\"");
	        // 循环取出流中的数据
	        byte[] b = new byte[100];
	        int len;
	        try {
	            while ((len = inStream.read(b)) > 0)
	                response.getOutputStream().write(b, 0, len);
	                inStream.close();
	        } catch (IOException e) {
	        	throw new IMRunTimeException(IMResp.FAIL);
	        }
		
	}
	
	
	public List<String> getGroupNameList() {
		return userInfoService.groupList();
	}
	
}
