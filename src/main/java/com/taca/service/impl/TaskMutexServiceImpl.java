package com.taca.service.impl;

import com.taca.mapper.TaskMutexMapper;
import com.taca.service.TaskMutexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by 芳华 on 2017/9/26.
 */
@Component("taskMutexService")
public class TaskMutexServiceImpl implements TaskMutexService{
    @Autowired
    private TaskMutexMapper taskMutexMapper;
    @Override
    public Set<Long> getMutexTaskIdList(Long id) {
         Set<Long> mutexTaskIdSet=new HashSet<Long>();
         mutexTaskIdSet.addAll(taskMutexMapper.getMutexFirstTaskIdList(id));
         mutexTaskIdSet.addAll(taskMutexMapper.getMutexSecondTaskIdList(id));
         return mutexTaskIdSet;
    }
}
