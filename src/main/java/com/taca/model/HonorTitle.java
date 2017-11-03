package com.taca.model;

import org.apache.ibatis.type.Alias;

import java.util.Date;
@Alias("HonorTitle")
public class HonorTitle {

    private Long id;

    private String title;

    private Long starNumber;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getStarNumber() {
        return starNumber;
    }

    public void setStarNumber(Long starNumber) {
        this.starNumber = starNumber;
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

    @Override
    public String toString() {
        return "HonorTitle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", starNumber=" + starNumber +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}