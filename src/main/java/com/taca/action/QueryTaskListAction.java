package com.taca.action;

import com.taca.common.bean.ResultBean;
import com.taca.common.constants.Constants;
import com.taca.common.constants.IMResp;
import com.taca.common.enumstatus.TaskStatus;
import com.taca.common.enumstatus.TransStatus;
import com.taca.common.exception.IMRunTimeException;
import com.taca.common.util.DateUtil;
import com.taca.common.util.FileToZip;
import com.taca.common.util.ZIPUtil;
import com.taca.model.ReceiveTask;
import com.taca.model.Submissions;
import com.taca.model.TaskInfo;
import com.taca.model.TransRecord;
import com.taca.service.ReceiveTaskService;
import com.taca.service.SubmissionsService;
import com.taca.service.TaskService;
import com.taca.vo.TaskList;

import net.sf.ehcache.search.aggregator.Count;

import org.apache.catalina.connector.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by asus on 2017/9/25.
 */
@Component
public class QueryTaskListAction {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ReceiveTaskService receiveTaskService;
    
    @Autowired 
    private SubmissionsService submissionsService;

    private static final Logger log = LoggerFactory.getLogger(QueryTaskListAction.class);

    /**
     * 提交用户反馈
     * @param
     * @return
     */
    @Transactional
    public int insertUserBack(String text,MultipartFile[] file,Long taskId,String userName,Long Id) throws IOException {
        ReceiveTask receiveTask = new ReceiveTask();
        TransRecord transRecord = new TransRecord();
        log.info("用户的名字是"+userName);
        Submissions submissions = new Submissions();
       
	        	
        String date=new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        String dirPath = Constants.SUBMIT_PATH+date+"_"+userName+"_"+taskId+"/";
        File dir = new File(dirPath);
        if(file.length==1&&file[0].getOriginalFilename().equals("")){
    		submissions.setFileAddress(null);
        }else{
        	if(dir.mkdir()){
        		for (int i = 0; i < file.length; i++) {
        			String fileName = file[i].getOriginalFilename();
        			int index = fileName.lastIndexOf(".");
        			fileName = i+"_submit"+fileName.substring(index);
        			String path  = dirPath+fileName;
        			System.setProperty("sun.jnu.encoding","utf-8");
        			File file2 = new File(path);
        				
        			try {
        				file[i].transferTo(file2);
        			} catch (IllegalStateException e) {
        				throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
        			} catch (IOException e) {
        				throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
        			}
        		}
        		
        		submissions.setFileAddress(dirPath);
        	}else{
        		throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
        	}
        }
	        	
        
        Date date1 = new Date();
        submissions.setReceiveBook(text);
        submissions.setReceiveTaskId(Id);
        submissions.setCreateTime(date1);
        submissions.setUpdateTime(date1);
        //插入用户任务完成记录
        transRecord.setStatus(TransStatus.PROCEEDING.toString());
        transRecord.setUsername(userName);
        transRecord.setCreateTime(new Date());
        transRecord.setUpdateTime(new Date());
        log.info("用户名字是"+userName+"id是"+Id);
        transRecord.setStarNumber(receiveTaskService.selectReceiveTask(Id).getPreStarNumber());
        receiveTaskService.insertTask(transRecord);
        log.info("======================交易ID"+transRecord.getId());
        //更新用户状态
        receiveTask.setId(Id);
        receiveTask.setUpdateTime(new Date());
        receiveTask.setTransId(transRecord.getId());
        receiveTask.setStatus(TaskStatus.PENDING.toString());
        receiveTaskService.updateTaskStauts(receiveTask);
        
        return receiveTaskService.insertUserBack(submissions);
    }
	        

    public List<TaskInfo> queryTaskList(String userId){
        return taskService.selectTaskInfoListKey(Long.parseLong(userId));
    }
    public TaskInfo queryTaskDetail(String userId){

        TaskInfo taskInfo = new TaskInfo();
        try{
         taskInfo =    taskService.queryTaskDetail(Long.parseLong(userId));
        }catch (Exception e){
            e.printStackTrace();
        }
        return  taskInfo;
    }
    public int taskSubmit(String gonsis,String photoUrl){
        ReceiveTask receiveTask = new ReceiveTask();
        return taskService.taskRevice(receiveTask);
    }

    /**
     * 返回任务列表
     * @param userName
     * @return
     */
    public   List<TaskList> selectUserTask(String userName){
        List<ReceiveTask> receiveTaskList = null;
        List<TaskList> taskLists = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            receiveTaskList = taskService.selectByUser(userName);
            for(int i=0;i<receiveTaskList.size();i++){
                TaskList taskList = new TaskList();
                Date endDate = receiveTaskList.get(i).getExpectedTime();
                if(!receiveTaskList.get(i).getStatus().equals("PROCEEDING")){
                	Submissions submissions = submissionsService.getByReceiveId(receiveTaskList.get(i).getId()); 
                	if(submissions!=null){
                		taskList.setFileAddress(submissions.getFileAddress());
                		taskList.setReceiveBook(submissions.getReceiveBook());
                	}
                	if(receiveTaskList.get(i).getStatus().equals("FINISHED")){
                		taskList.setAuditStatus(submissions.getStatus());
                		taskList.setRejectMessage(submissions.getMessage());
                	}
                }
                Date startDate =receiveTaskList.get(i).getStartTime();
                taskList.setId(receiveTaskList.get(i).getId());
               
                taskList.setTaskId(receiveTaskList.get(i).getTaskId());
                TaskInfo taskInfo = taskService.getTaskById(receiveTaskList.get(i).getTaskId());
                String feedBackWay = taskInfo.getFeedbackWay();
                taskList.setFeedBackWay(feedBackWay);
                taskList.setStarNumber(receiveTaskList.get(i).getPreStarNumber());
                taskList.setActStarNumber(receiveTaskList.get(i).getActStarNumber());
                taskList.setUserName(receiveTaskList.get(i).getUserName().trim());
                taskList.setTaskName(receiveTaskList.get(i).getName());
                taskList.setContent(receiveTaskList.get(i).getContent());
                taskList.setHadFinished(DateUtil.subDate(startDate,new Date()));
                taskList.setNeedFinish(taskInfo.getTimeLength()-taskList.getHadFinished());
               // taskList.setNeedFinish(DateUtil.subDate(new Date(),endDate));
               // taskList.setNeedFinish(1+Integer.parseInt(String.valueOf((endDate.getTime() - new Date().getTime()) / (24 * 3600 * 1000))));
                taskList.setStartTime(sdf.format(startDate));
                taskList.setEndTime(sdf.format(endDate));
                taskList.setStatus(receiveTaskList.get(i).getStatus());
                taskList.setCreateTime(receiveTaskList.get(i).getCreateTime());
                
                taskList.setStar(Integer.parseInt(String.valueOf(taskInfo.getStarLevel())));
                List<Long> list = new ArrayList<>();
                for(int j=0;j<taskInfo.getStarLevel();j++){
                	list.add(1L);
                }
                taskList.setStarList(list);
                taskList.setPersonNum(receiveTaskService.selectTaskUser(receiveTaskList.get(i).getName()).size()-1);
                taskLists.add(taskList);
            }
        return taskLists;
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
	
	
}
