package com.taca.mapper;


import com.taca.model.ReceiveTask;
import com.taca.model.UserInfo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
public interface ReceiveTaskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ReceiveTask record);

    int insertSelective(ReceiveTask record);

    ReceiveTask selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ReceiveTask record);

    int updateByPrimaryKeyWithBLOBs(ReceiveTask record);

    int updateByPrimaryKey(ReceiveTask record);

    int getReceiveCount(Map param);

    ReceiveTask selectByIdAndUM(Map param);

    List<Long> getTaskByUM(String UM);
    Integer countReceive();
    /**
     * 查询用户的所参加的任务
     */
    List<ReceiveTask> selectByUser(String userName);

    /**
     * 根据任务名字查找参加本次任务的人数
     * @param taskName
     * @return
     */
    List<String> selectTaskUser(String taskName);

    /**
     * 更新用户任务记录
     */
    int updateTaskStatus(ReceiveTask record);


    ReceiveTask selectReceiveTask(Long Id);

    Integer count(Map<String, Object> map);
    List<ReceiveTask> getList(Map map);


    List<ReceiveTask> queryList(ReceiveTask reciveTask);

    Integer audit(ReceiveTask reciveTask);

    List<ReceiveTask> getAuditList(Map map);

    Integer countForAudit(ReceiveTask reciveTask);

    String getUserNameByReceiveId(Long id);
    Long getTransIdByReceiveId(Long id);
    List<ReceiveTask> getMonthList(Map map);
    ReceiveTask getById(Long id);
    
    Set<String> getUserListForSendEmail();
    List<ReceiveTask> getReceiveTaskListFin();

	List<ReceiveTask> getTimeOutReceiveTask();
 }