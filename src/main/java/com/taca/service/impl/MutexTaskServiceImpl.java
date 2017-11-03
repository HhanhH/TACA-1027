package com.taca.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taca.common.constants.IMResp;
import com.taca.common.exception.DBException;
import com.taca.mapper.TaskMutexMapper;
import com.taca.model.TaskMutex;
import com.taca.service.MutexTaskService;

@Component("mutexTaskService")
public class MutexTaskServiceImpl implements MutexTaskService {

	@Autowired
	private TaskMutexMapper taskMutexMapper;
	
	@Override
	public List<TaskMutex> queryMutexTaskList(TaskMutex taskMutex) {
		List<TaskMutex> list = null;
		list = taskMutexMapper.queryList(taskMutex);
		return list;
	}
	
	 @Override
	 public Set<Long> getMutexTaskIdList(Long id) {
		 Set<Long> mutexTaskIdSet=new HashSet<Long>();
		 mutexTaskIdSet.addAll(taskMutexMapper.getMutexFirstTaskIdList(id));
		 mutexTaskIdSet.addAll(taskMutexMapper.getMutexSecondTaskIdList(id));
		 return mutexTaskIdSet;
	 }

	@Override
	public Integer add(TaskMutex taskMutex) {
		Date date=new Date();
		taskMutex.setCreateTime(date);
		taskMutex.setUpdateTime(date);
		return taskMutexMapper.insert(taskMutex);
	}

	@Override
	public Integer deleteMutex(Long id) {
		return taskMutexMapper.deleteMutex(id);
	}

	@Override
	public TaskMutex getTaskMutexByFirstIdAndSecondId(Long taskId,
			Long mutexTaskId) {
		TaskMutex taskMutex = new TaskMutex();
		taskMutex.setTaskFirstId(taskId);
		taskMutex.setTaskSecondId(mutexTaskId);
		return taskMutexMapper.getMutexTaskByFirstIdAndSecondId(taskMutex);
	}
	 

}
