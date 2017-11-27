package com.taca.busservice;

import com.taca.common.bean.ResultBean;
import com.taca.common.constants.IMResp;
import com.taca.common.exception.BusinessException;
import com.taca.common.util.DateUtil;
import com.taca.controller.mobile.LoginMobileController;
import com.taca.mapper.ReceiveTaskMapper;
import com.taca.mapper.TaskInfoMapper;
import com.taca.model.ReceiveTask;
import com.taca.model.TaskInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.taca.common.enumstatus.*;

import java.util.Date;

/**
 * Created by 芳华 on 2017/9/26.
 */
@Component("receiveTaskBusService")
public class ReceiveTaskBusService {

    private static final Logger log = LoggerFactory.getLogger(LoginMobileController.class);

    @Autowired
    private TaskInfoMapper taskInfoMapper;
    @Autowired
    private ReceiveTaskMapper receiveTaskMapper;

    @Transactional
    public ResultBean receiveTask(Long id,String username){
        TaskInfo taskInfo=taskInfoMapper.selectByPrimaryKey(id);
        if(taskInfo==null){
            throw new BusinessException(IMResp.FAIL);
        }
        //1.可领取次数-1，领取次数+1
        taskInfo.setAvailableStock(taskInfo.getAvailableStock()-1);
        taskInfo.setCount(taskInfo.getCount()+1);
        taskInfo.setUpdateTime(new Date());
        taskInfoMapper.updateByPrimaryKeySelective(taskInfo);
        //2.更新ReceiveTask记录
        ReceiveTask receiveTask=new ReceiveTask();
        receiveTask.setTaskId(id);
        receiveTask.setTransId(0L);
        receiveTask.setUserName(username);
        receiveTask.setName(taskInfo.getName());
        receiveTask.setContent(taskInfo.getContent());
        receiveTask.setPreStarNumber(taskInfo.getStarProfit());
        receiveTask.setStatus(TaskStatus.PROCEEDING.toString());
        receiveTask.setStartTime(new Date());
        receiveTask.setExpectedTime(DateUtil.getDateAfter(new Date(),taskInfo.getTimeLength().intValue()+1));
        System.out.println(receiveTask.getExpectedTime());
        receiveTask.setCreateTime(new Date());
        receiveTask.setUpdateTime(new Date());
        receiveTaskMapper.insert(receiveTask);

        return new ResultBean(IMResp.SUCCESS);
    }

}
