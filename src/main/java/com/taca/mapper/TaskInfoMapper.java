package com.taca.mapper;


import com.taca.common.exception.DBException;
import com.taca.model.TaskInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TaskInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TaskInfo record);

    int insertSelective(TaskInfo record);

    TaskInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaskInfo record);

    int updateByPrimaryKeyWithBLOBs(TaskInfo record);

    int updateByPrimaryKey(TaskInfo record);

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

    List<TaskInfo> selectTaskListByKey(Long id);

    Integer changOffAndOnById(Map<String, Object> map);

    Integer count(TaskInfo taskInfo);

    List<TaskInfo> queryTaskList(Map map);

    List<TaskInfo> queryList(TaskInfo taskInfo);

    Integer countByMap(Map<String, Object> map);

    List<String> getCategoryList();
}