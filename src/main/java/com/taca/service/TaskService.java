package com.taca.service;

import com.taca.common.util.Page;
import com.taca.model.ReceiveTask;
import com.taca.model.TaskInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by 芳华 on 2017/9/22.
 */
public interface TaskService {
    List<TaskInfo> getHotTaskList();
    List<TaskInfo> getNewTaskList();
    List<TaskInfo> getTaskListByTimeDesc();
    List<TaskInfo> getTaskListByTimeAsc();
    List<TaskInfo> getTaskListByStarNumberDesc();
    List<TaskInfo> getTaskListByStarNumberAsc();
    List<TaskInfo> getTaskListByTimeLengthDesc();
    List<TaskInfo> getTaskListByTimeLengthAsc();
    List<TaskInfo> getTaskListByCategory(String category);
    List<TaskInfo> getTaskListByStarLevel(Long starLevel);
    List<String> getTypeList();
    List<Long> getStarLevelList();
    TaskInfo getTaskById(Long id);
    List<TaskInfo> selectTaskInfoListKey(Long id);
    TaskInfo queryTaskDetail(Long id);
    int taskRevice(ReceiveTask receiveTask );

    /**
     * 根据用户名查找参加的任务
     * @param userName
     * @return
     */
    List<ReceiveTask> selectByUser(String userName);



    List<TaskInfo> getTaskList(TaskInfo taskInfo);
    TaskInfo queryTaskInfoById(Long Id);
    Integer insertTask(TaskInfo taskInfo);
    Integer changOffAndOn(Map map);
    Integer updateTask(TaskInfo taskInfo) ;

    Integer getCount(Map<String , Object> map,TaskInfo taskInfo) ;

    List<String > getCategoryList();

    List<TaskInfo> queryTaskList(Map<String , Object> map ,TaskInfo taskInfo,Page page);
    
  
}
