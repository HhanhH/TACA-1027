package com.taca.model;

import org.apache.ibatis.type.Alias;

import java.util.Date;
@Alias("UserInfo")
public class UserInfo {

    private Long id;

    private String userName;

    private String nickName;

    private String userNameCn;

    private String password;

    private String iconAddress;

    private String wxOpenId;

    private Long availableStar;

    private String emailAddress;

    private Long freezeStar;

    private Long historyStar;

    private Long groupId;

    private String groupName;

    private String honorTitle;

    private String um;

    private String status;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserNameCn() {
        return userNameCn;
    }

    public void setUserNameCn(String userNameCn) {
        this.userNameCn = userNameCn;
    }

    public String getIconAddress() {
        return iconAddress;
    }

    public void setIconAddress(String iconAddress) {
        this.iconAddress = iconAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public Long getAvailableStar() {
        return availableStar;
    }

    public void setAvailableStar(Long availableStar) {
        this.availableStar = availableStar;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getFreezeStar() {
        return freezeStar;
    }

    public void setFreezeStar(Long freezeStar) {
        this.freezeStar = freezeStar;
    }

    public Long getHistoryStar() {
        return historyStar;
    }

    public void setHistoryStar(Long historyStar) {
        this.historyStar = historyStar;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getHonorTitle() {
        return honorTitle;
    }

    public void setHonorTitle(String honorTitle) {
        this.honorTitle = honorTitle;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userNameCn='" + userNameCn + '\'' +
                ", password='" + password + '\'' +
                ", wxOpenId='" + wxOpenId + '\'' +
                ", availableStar=" + availableStar +
                ", emailAddress='" + emailAddress + '\'' +
                ", freezeStar=" + freezeStar +
                ", historyStar=" + historyStar +
                ", groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", honorTitle='" + honorTitle + '\'' +
                ", um='" + um + '\'' +
                ",status='"+status+'\''+
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}