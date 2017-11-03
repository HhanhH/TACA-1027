package com.taca.action;

import com.taca.busservice.ReceiveTaskBusService;
import com.taca.common.bean.ResultBean;
import com.taca.common.constants.AdminConstants;
import com.taca.common.constants.Constants;
import com.taca.common.constants.IMResp;
import com.taca.common.exception.BusinessException;
import com.taca.common.exception.IMRunTimeException;
import com.taca.common.util.Page;
import com.taca.controller.mobile.LoginMobileController;
import com.taca.model.ReceiveTask;
import com.taca.model.TaskInfo;
import com.taca.model.TaskMutex;
import com.taca.service.MutexTaskService;
import com.taca.service.ReceiveTaskService;
import com.taca.service.TaskMutexService;
import com.taca.service.TaskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 芳华 on 2017/9/22.
 */
@Component("taskAction")
public class TaskAction {

    private static final Logger log = LoggerFactory.getLogger(LoginMobileController.class);

    @Autowired
    private TaskService taskService;
    @Autowired
    private ReceiveTaskService receiveTaskService;
    @Autowired
    private TaskMutexService taskMutexService;
    @Autowired
    private ReceiveTaskBusService receiveTaskBusService;

    @Autowired
    private MutexTaskService mutexTaskService;

    public List<TaskInfo> getHotTaskList(){
        return taskService.getHotTaskList();
    }
    public List<TaskInfo> getNewTaskList(){
        return taskService.getNewTaskList();
    }
    public List<TaskInfo> getTaskListByTimeDesc(){
        return taskService.getTaskListByTimeDesc();
    }
    public List<TaskInfo> getTaskListByTimeAsc(){
        return taskService.getTaskListByTimeAsc();
    }
    public List<TaskInfo> getTaskListByStarNumberDesc(){
        return taskService.getTaskListByStarNumberDesc();
    }
    public List<TaskInfo> getTaskListByStarNumberAsc(){
        return taskService.getTaskListByStarNumberAsc();
    }
    public List<TaskInfo> getTaskListByTimeLengthDesc(){
        return taskService.getTaskListByTimeLengthDesc();
    }
    public List<TaskInfo> getTaskListByTimeLengthAsc(){
        return taskService.getTaskListByTimeLengthAsc();
    }
    public List<TaskInfo> getTaskListByCategory(String category){
        return taskService.getTaskListByCategory(category);
    }
    public List<TaskInfo> getTaskListByStarLevel(Long starLevel){
        return taskService.getTaskListByStarLevel(starLevel);
    }
    public List<String> getTypeList(){
        return taskService.getTypeList();
    }
    public List<Long> getStarLevelList(){
        return taskService.getStarLevelList();
    }

    public TaskInfo getTaskById(Long id){
        return taskService.getTaskById(id);
    }

    public ResultBean receiveTask(Long id, HttpSession httpSession){
        String username=(String)httpSession.getAttribute("username");
        //1.判断该任务是否在进行中
        ReceiveTask receiveTask=receiveTaskService.getReceiveTaskById(id,username);
        if(receiveTask!=null){
            throw new BusinessException(IMResp.TASK_IS_DOING);
        }
        //2.判断是否已经领取了与该任务互斥的任务
        Set<Long> MutexTaskIdList=taskMutexService.getMutexTaskIdList(id);
        List<Long> taskListOnGoing=receiveTaskService.getTaskIsDoing(username);
        if(MutexTaskIdList!=null&&taskListOnGoing!=null){
            for(Long taskId:taskListOnGoing){
                if(MutexTaskIdList.contains(taskId)){
                    throw new BusinessException(IMResp.TASK_IS_MUTEX);
                }
            }
        }
        //3.判断领取次数是否超过上限
        Long personAvailableStock=taskService.getTaskById(id).getPersonAvailableStock();
        if(personAvailableStock!=null){
            int receiveCount=receiveTaskService.getReceiveCount(id,username);
            if(receiveCount>=personAvailableStock){
                throw new BusinessException(IMResp.RECEIVE_OVERFLOW);
            }
        }
        else {
           throw new BusinessException(IMResp.FIELD_IS_NULL);
        }
        //4.领取任务
       return  receiveTaskBusService.receiveTask(id,username);
    }
    @SuppressWarnings("unchecked")
    public List<TaskInfo> queryTaskList(Map< String , Object> map,TaskInfo taskInfo,Page page) {
        List<TaskInfo> taList;

        int count= taskService.getCount(map,taskInfo);
        page.setTotalNumber(count);
        page.count();
        taList = taskService.queryTaskList(map,taskInfo,page);
        if(taList.isEmpty()){
            return null;
        }
        for (TaskInfo info : taList) {
            Set<Long> set = null;
            set = mutexTaskService.getMutexTaskIdList(info.getId());
            info.setMutexTaskList(set);
        }
        return taList;

    }
    public List<TaskInfo> getTaskListForMutex() {
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setStatus("ON");
        List<TaskInfo> list = taskService.getTaskList(taskInfo);
        if(list.isEmpty()){
			return null;
		}
		for (TaskInfo info : list) {
			Set<Long> set = null;
			set = mutexTaskService.getMutexTaskIdList(info.getId());
			info.setMutexTaskList(set);
		}
        return list;
    }
    
    
    public List<TaskInfo> getTaskList(TaskInfo taskInfo) {
        List<TaskInfo> taList;
        taList = taskService.getTaskList(taskInfo);
        if(taList.isEmpty()){
            return null;
        }
        for (TaskInfo info : taList) {
            Set<Long> set = null;
            set = mutexTaskService.getMutexTaskIdList(info.getId());
            info.setMutexTaskList(set);
        }
        return taList;

    }

    public TaskInfo queryTaskInfoById(Long id) {
        TaskInfo taskInfo=null;
        taskInfo = taskService.queryTaskInfoById(id);
        Set<Long> set = null;
        set = mutexTaskService.getMutexTaskIdList(taskInfo.getId());
        taskInfo.setMutexTaskList(set);
        return taskInfo;
    }


    public void insertNewTask(MultipartFile file,TaskInfo taskInfo,HttpServletRequest request) {
        if(StringUtils.isEmpty(file.getOriginalFilename())){
            taskInfo.setIconAddress(null);
        }else{
            String fileName = file.getOriginalFilename();
            int index = fileName.lastIndexOf(".");
            String date=new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
            fileName = date+"_task"+fileName.substring(index);
            String path  = Constants.PIC_PATH+fileName;
            System.setProperty("sun.jnu.encoding","utf-8");
            File file2 = new File(path);

            try {
                file.transferTo(file2);
            } catch (IllegalStateException e) {
                throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
            } catch (IOException e) {
                throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
            }
            taskInfo.setIconAddress(path);
        }
        if(taskInfo.getPersonAvailableStock()==null){
        	taskInfo.setPersonAvailableStock(9999L);
        }
        taskInfo.setCount(0L);
        Integer flag=0;
        flag=taskService.insertTask(taskInfo);
    }

    public List<ReceiveTask> queryReceiveTaskList(Map<String, Object> map,ReceiveTask receiveTask,Page page)
    {
        map.put("receiveTask", receiveTask);
        List<ReceiveTask> list= new ArrayList<>();
        int count= receiveTaskService.count(map);
        page.setTotalNumber(count);
        page.count();
        map.put("page", page);
        list = receiveTaskService.queryReciveTaskList(map);
        return list;

    }
    public List<String > getCategoryList() {
        return taskService.getCategoryList();
    }

    public Integer changOffAndOn(Long id){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        Date date=new Date();
        map.put("updateTime", date);
        TaskInfo taskInfo = taskService.queryTaskInfoById(id);
        if(taskInfo.getStatus().equalsIgnoreCase("ON")){
            map.put("status", AdminConstants.TASK_STATUS_OFF);
        }else{
            map.put("status", AdminConstants.TASK_STATUS_ON);
        }
        Integer integer=0;
        integer = taskService.changOffAndOn(map);
        return integer;
    }

    public Integer  updateTaskInfo(MultipartFile file, TaskInfo taskInfo) {
        if(StringUtils.isEmpty(file.getOriginalFilename())){
            taskInfo.setIconAddress(null);
        }else{
            String fileName = file.getOriginalFilename();
            int index = fileName.lastIndexOf(".");
            fileName= taskInfo.getId()+fileName.substring(index);
            String date=new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
            fileName = date+"_task"+fileName;
            String path  = Constants.PIC_PATH+fileName;
            System.setProperty("sun.jnu.encoding","utf-8");
            File file2 = new File(path);

            try {
                file.transferTo(file2);
            } catch (IllegalStateException e) {
                throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
            } catch (IOException e) {
                throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
            }
            taskInfo.setIconAddress(path);
        }
        Integer flag = taskService.updateTask(taskInfo);
        return flag;

    }
    public Integer addTaskMutex(TaskMutex taskMutex) {
        if(taskMutex.getTaskFirstId()==taskMutex.getTaskSecondId()){
            throw new IMRunTimeException(IMResp.CANNOT_CHOOSE_SELF);
        }
        Set<Long> set = mutexTaskService.getMutexTaskIdList(taskMutex.getTaskFirstId());
        if(set.contains(taskMutex.getTaskSecondId())){
            throw new IMRunTimeException(IMResp.DATA_EXISTS);
        }

        Integer count =mutexTaskService.add(taskMutex);
        return count;
    }

    public  ResultBean removeMutex(Long taskId,Long mutexTaskId) {
    	TaskMutex taskMutex = mutexTaskService.getTaskMutexByFirstIdAndSecondId(taskId, mutexTaskId);
    	if(taskMutex ==null){
    		taskMutex = mutexTaskService.getTaskMutexByFirstIdAndSecondId(mutexTaskId, taskId);
    	}
    	
    	mutexTaskService.deleteMutex(taskMutex.getId());
		return new ResultBean<>();
	}
}
