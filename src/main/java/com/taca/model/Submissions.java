package com.taca.model;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("Submissions")
public class Submissions {

    private Long id;

    private Long receiveTaskId;

    private String fileAddress;

    private  String receiveBook;
    private String status;
    private String message;

    public String getReceiveBook() {
        return receiveBook;
    }

    public void setReceiveBook(String receiveBook) {
        this.receiveBook = receiveBook;
    }

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReceiveTaskId() {
        return receiveTaskId;
    }

    public void setReceiveTaskId(Long receiveTaskId) {
        this.receiveTaskId = receiveTaskId;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
		return "Submissions [id=" + id + ", receiveTaskId=" + receiveTaskId
				+ ", fileAddress=" + fileAddress + ", receiveBook="
				+ receiveBook + ", status=" + status + ", message=" + message
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}
    
    
}