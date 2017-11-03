package com.taca.model;

import org.apache.ibatis.type.Alias;

import java.util.Date;
@Alias("TaskMutex")
public class TaskMutex {

    private Long id;

    private Long taskFirstId;

    private Long taskSecondId;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskFirstId() {
        return taskFirstId;
    }

    public void setTaskFirstId(Long taskFirstId) {
        this.taskFirstId = taskFirstId;
    }

    public Long getTaskSecondId() {
        return taskSecondId;
    }

    public void setTaskSecondId(Long taskSecondId) {
        this.taskSecondId = taskSecondId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}