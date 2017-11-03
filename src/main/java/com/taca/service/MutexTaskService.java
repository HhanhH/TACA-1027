package com.taca.service;

import java.util.List;
import java.util.Set;

import com.taca.model.TaskMutex;

public interface MutexTaskService {
	public List<TaskMutex> queryMutexTaskList(TaskMutex taskMutex) ;

	 Set<Long> getMutexTaskIdList(Long id);	
	 
	 Integer add(TaskMutex taskMutex);
	 
	 Integer deleteMutex(Long id);
	 
	 TaskMutex getTaskMutexByFirstIdAndSecondId(Long taskId,Long mutexTaskId);
}
