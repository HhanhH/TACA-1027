package com.taca.model;

import org.apache.ibatis.type.Alias;

import java.util.Date;
@Alias("ReceiveTask")
public class ReceiveTask {
    private Long id;

    private Long taskId;

    private String userName;

    private String name;

    private Long actStarNumber;

    private Long preStarNumber;

    private String status;

    private Long transId;

    private Date startTime;

    private Date expectedTime;

    private Date finishedTime;

    private Date createTime;

    private Date updateTime;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getActStarNumber() {
        return actStarNumber;
    }

    public void setActStarNumber(Long actStarNumber) {
        this.actStarNumber = actStarNumber;
    }

    public Long getPreStarNumber() {
        return preStarNumber;
    }

    public void setPreStarNumber(Long preStarNumber) {
        this.preStarNumber = preStarNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Date expectedTime) {
        this.expectedTime = expectedTime;
    }

    public Date getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}