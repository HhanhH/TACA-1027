package com.taca.service;

import com.taca.common.util.Page;
import com.taca.model.ReceiveTask;
import com.taca.model.Submissions;
import com.taca.model.TransRecord;
import com.taca.model.UserInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 芳华 on 2017/9/25.
 */
public interface ReceiveTaskService {
    public int getReceiveCount(Long id,String UM);
    public ReceiveTask getReceiveTaskById(Long id,String UM);
    public List<Long> getTaskIsDoing(String UM);
    /**
     * 更新用户任务
     */
    int updateTaskStauts(ReceiveTask receiveTask);

    /**
     * 用户任务完成情况交易
     * @param transRecord
     */
    Long insertTask(TransRecord transRecord);
    /**
     * 查询用户信息
     */
    ReceiveTask selectReceiveTask(Long Id);
    /**
     * 用户提交反馈
     */
    int insertUserBack(Submissions submissions);
    List<ReceiveTask> queryReciveTaskList(Map<String, Object> map) ;
    Integer count(Map<String, Object> map);
    List<ReceiveTask> getMonthList(String monthBegin,String monthEnd,Page page);
    Integer countReceive();

    String getUserNameById(Long id);
    ReceiveTask getById(Long id);
    List<String> selectTaskUser(String taskName);
    Set<String> getUserListForSendEmail();
    List<ReceiveTask> getReceiveTaskListFin();
    List<ReceiveTask> getTimeOutReceiveTask();

}
