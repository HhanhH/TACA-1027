package com.taca.service.impl;

import com.taca.common.util.Page;
import com.taca.mapper.ReceiveTaskMapper;
import com.taca.mapper.SubmissionsMapper;
import com.taca.mapper.TransRecordMapper;
import com.taca.mapper.UserInfoMapper;
import com.taca.model.ReceiveTask;
import com.taca.model.Submissions;
import com.taca.model.TransRecord;
import com.taca.model.UserInfo;
import com.taca.service.ReceiveTaskService;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 芳华 on 2017/9/25.
 */
@Component("receiveTaskService")
public class ReceiveTaskServiceImpl implements ReceiveTaskService{

    @Autowired
    private ReceiveTaskMapper receiveTaskMapper;

    @Autowired
    private TransRecordMapper transRecordMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private SubmissionsMapper submissionsMapper;
    @Override
    public int getReceiveCount(Long id, String UM) {
        Map<String,Object> param=new HashedMap();
        param.put("id",id);
        param.put("UM",UM);
        return receiveTaskMapper.getReceiveCount(param);
    }

    @Override
    public ReceiveTask getReceiveTaskById(Long id,String UM) {
        Map<String,Object> param=new HashedMap();
        param.put("id",id);
        param.put("UM",UM);
        return receiveTaskMapper.selectByIdAndUM(param);
    }

    @Override
    public List<Long> getTaskIsDoing(String UM) {
        return receiveTaskMapper.getTaskByUM(UM);
    }

    @Override
    public int updateTaskStauts(ReceiveTask receiveTask) {
        return receiveTaskMapper.updateTaskStatus(receiveTask);
    }
    @Override
    public Long insertTask(TransRecord transRecord) {
        return transRecordMapper.insertTask(transRecord);
    }

    @Override
    public ReceiveTask selectReceiveTask(Long Id) {
        return receiveTaskMapper.selectReceiveTask(Id);
    }

    public int insertUserBack(Submissions submissions) {
        return submissionsMapper.insertUserBack(submissions);
    }

    @Override
    public Integer count(Map<String, Object> map) {
        return receiveTaskMapper.count(map);
    }

    @Override
    public List<ReceiveTask> queryReciveTaskList(Map<String, Object> map) {

        return receiveTaskMapper.getList(map);
    }
    @Override
    public List<ReceiveTask> getMonthList(String monthBegin, String monthEnd,
                                         Page page) {
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("monthBegin", monthBegin);
        map.put("monthEnd", monthEnd);
        map.put("page", page);
        return receiveTaskMapper.getMonthList(map);
    }
    @Override
    public Integer countReceive() {

        return receiveTaskMapper.countReceive();
    }

    @Override
    public String getUserNameById(Long id) {
        return receiveTaskMapper.getUserNameByReceiveId(id);
    }
    @Override
    public ReceiveTask getById(Long id) {
        return receiveTaskMapper.getById(id);
    }
    @Override
    public List<String> selectTaskUser(String taskName) {
        return  receiveTaskMapper.selectTaskUser(taskName);
    }

	@Override
	public Set<String> getUserListForSendEmail() {
		return receiveTaskMapper.getUserListForSendEmail();
	}

	@Override
	public List<ReceiveTask> getReceiveTaskListFin() {
		return receiveTaskMapper.getReceiveTaskListFin();
	}

	@Override
	public List<ReceiveTask> getTimeOutReceiveTask() {
		// TODO Auto-generated method stub
		return receiveTaskMapper.getTimeOutReceiveTask();
	}
}
