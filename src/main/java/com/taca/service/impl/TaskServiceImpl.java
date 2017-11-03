package com.taca.service.impl;

import com.taca.common.exception.DBException;
import com.taca.common.util.Page;
import com.taca.mapper.ReceiveTaskMapper;
import com.taca.mapper.TaskInfoMapper;
import com.taca.model.ReceiveTask;
import com.taca.model.TaskInfo;
import com.taca.service.TaskService;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by 芳华 on 2017/9/22.
 */
@Component("taskService")
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskInfoMapper taskInfoMapper;

    @Autowired
    private ReceiveTaskMapper receiveTaskMapper;

    @Override
    public List<TaskInfo> getHotTaskList() {
        return taskInfoMapper.getHotTaskList();
    }

    @Override
    public List<TaskInfo> getNewTaskList() {
        return taskInfoMapper.getNewTaskList();
    }

    @Override
    public List<TaskInfo> getTaskListByTimeDesc() {
        return taskInfoMapper.getTaskListByTimeDesc();
    }

    @Override
    public List<TaskInfo> getTaskListByTimeAsc() {
        return taskInfoMapper.getTaskListByTimeAsc();
    }

    @Override
    public List<TaskInfo> getTaskListByStarNumberDesc() {
        return taskInfoMapper.getTaskListByStarNumberDesc();
    }

    @Override
    public List<TaskInfo> getTaskListByStarNumberAsc() {
        return taskInfoMapper.getTaskListByStarNumberAsc();
    }

    @Override
    public List<TaskInfo> getTaskListByTimeLengthDesc() {
        return taskInfoMapper.getTaskListByTimeLengthDesc();
    }

    @Override
    public List<TaskInfo> getTaskListByTimeLengthAsc() {
        return taskInfoMapper.getTaskListByTimeLengthAsc();
    }

    @Override
    public List<TaskInfo> getTaskListByCategory(String category) {
        return taskInfoMapper.getTaskListByCategory(category);
    }

    @Override
    public List<TaskInfo> getTaskListByStarLevel(Long starLevel) {
        return taskInfoMapper.getTaskListByStarLevel(starLevel);
    }

    @Override
    public List<String> getTypeList(){
        return taskInfoMapper.getTypeList();
    }

    @Override
    public List<Long> getStarLevelList() {
        return taskInfoMapper.getStarLevelList();
    }

    @Override
    public TaskInfo getTaskById(Long id) {
        return taskInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TaskInfo> selectTaskInfoListKey(Long id) {

        return taskInfoMapper.selectTaskListByKey(id);
    }

    public TaskInfo queryTaskDetail(Long id) {


        return taskInfoMapper.selectByPrimaryKey(id);
    }

    public int taskRevice(ReceiveTask receiveTask) {

        return receiveTaskMapper.insert(receiveTask);
    }

    @Override
    public List<ReceiveTask> selectByUser(String userName) {
        return receiveTaskMapper.selectByUser(userName);
    }



    @Override
    public List<TaskInfo> queryTaskList(Map<String , Object> map,TaskInfo taskInfo,Page page) {
        List<TaskInfo> list = new ArrayList<>();
        map.put("taskInfo", taskInfo);
        map.put("page", page);
        list=taskInfoMapper.queryTaskList(map);
        return list;
    }

    @Override
    public List<TaskInfo> getTaskList(TaskInfo taskInfo) {
        List<TaskInfo> list = new ArrayList<>();
        list=taskInfoMapper.queryList(taskInfo);
        return list;
    }


    @Override
    public TaskInfo queryTaskInfoById(Long id) {
        TaskInfo taskInfo= null;
        taskInfo=taskInfoMapper.selectByPrimaryKey(id);
        return taskInfo;
    }
    @Override
    public Integer insertTask(TaskInfo taskInfo) {
        Integer flag = 0;
        Date date= new Date();
        taskInfo.setCreateTime(date);
        taskInfo.setUpdateTime(date);
        flag = taskInfoMapper.insert(taskInfo);
        return flag;
    }


    @Override
    public Integer changOffAndOn(Map map) {
        Integer flag=taskInfoMapper.changOffAndOnById(map);
        return flag;
    }

    @Override
    public Integer getCount(Map<String , Object> map,TaskInfo taskInfo) {
        map.put("taskInfo", taskInfo);
        return taskInfoMapper.countByMap(map);
    }


    @Override
    public List<String> getCategoryList() {
        return taskInfoMapper.getCategoryList();
    }

    @Override
    public Integer updateTask(TaskInfo taskInfo) {
        Date date = new Date();
        taskInfo.setUpdateTime(date);
        Integer flag = taskInfoMapper.updateByPrimaryKeySelective(taskInfo);
        return flag;
    }

	
}
