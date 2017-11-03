package com.taca.model;

import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Alias("TaskInfo")
public class TaskInfo {

    private Long id;

    private String type;

    private String name;

    private String iconAddress;

    private Long starLevel;

    private Long starProfit;

    private Set<Long> mutexTaskList;

    private Long timeLength;

    private String status;

    private Long availableStock;

    private Long personAvailableStock;

    private String feedbackWay;

    private Long count;

    private String category;

    private Date createTime;

    private Date updateTime;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconAddress() {
        return iconAddress;
    }

    public void setIconAddress(String iconAddress) {
        this.iconAddress = iconAddress;
    }

    public Long getStarLevel() {
        return starLevel;
    }

    public Set<Long> getMutexTaskList() {
        return mutexTaskList;
    }

    public void setMutexTaskList(Set<Long> mutexTaskList) {
        this.mutexTaskList = mutexTaskList;
    }

    public void setStarLevel(Long starLevel) {
        this.starLevel = starLevel;
    }

    public Long getStarProfit() {
        return starProfit;
    }

    public void setStarProfit(Long starProfit) {
        this.starProfit = starProfit;
    }

    public Long getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Long timeLength) {
        this.timeLength = timeLength;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(Long availableStock) {
        this.availableStock = availableStock;
    }

    public Long getPersonAvailableStock() {
        return personAvailableStock;
    }

    public void setPersonAvailableStock(Long personAvailableStock) {
        this.personAvailableStock = personAvailableStock;
    }

    public String getFeedbackWay() {
        return feedbackWay;
    }

    public void setFeedbackWay(String feedbackWay) {
        this.feedbackWay = feedbackWay;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    @Override
    public String toString() {
        return "TaskInfo{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", iconAddress='" + iconAddress + '\'' +
                ", starLevel=" + starLevel +
                ", starProfit=" + starProfit +
                ", timeLength='" + timeLength + '\'' +
                ", status='" + status + '\'' +
                ", availableStock=" + availableStock +
                ", personAvailableStock=" + personAvailableStock +
                ", feedbackWay='" + feedbackWay + '\'' +
                ", count=" + count +
                ", category='" + category + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", content='" + content + '\'' +
                '}';
    }
}