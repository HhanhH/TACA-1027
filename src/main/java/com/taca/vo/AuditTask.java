package com.taca.vo;

import java.util.Date;


public class AuditTask {

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

	    private String content;

	    private String fileAddress;
	    
	    private String message;
	    
	    private String receiveBook;
	    
	    private String feedBackWay;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getFileAddress() {
			return fileAddress;
		}
		public void setFileAddress(String fileAddress) {
			this.fileAddress = fileAddress;
		}

	public String getReceiveBook() {
		return receiveBook;
	}

	public void setReceiveBook(String receiveBook) {
		this.receiveBook = receiveBook;
	}

	public Long getTransId() {
			return transId;
		}
		public void setTransId(Long transId) {
			this.transId = transId;
		}
		
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		@Override
		public String toString() {
			return "AuditTask [id=" + id + ", taskId=" + taskId + ", name="
					+ name + ", actStarNumber=" + actStarNumber
					+ ", preStarNumber=" + preStarNumber + ", status=" + status
					+ ", transId=" + transId + ", startTime=" + startTime
					+ ", expectedTime=" + expectedTime + ", finishedTime="
					+ finishedTime + ", content=" + content + ", fileAddress="
					+ fileAddress + ", message=" + message + ", receiveBook="
					+ receiveBook + "]";
		}
		public String getFeedBackWay() {
			return feedBackWay;
		}
		public void setFeedBackWay(String feedBackWay) {
			this.feedBackWay = feedBackWay;
		}
		
	    
	}


