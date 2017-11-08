package com.taca.vo;

import java.util.Date;
import java.util.List;


/**
 * Created by asus on 2017/9/27.
 */
public class TaskList {

    private Long id;

    private String userName;
    //任务星级
    private int star;

    private Long starNumber;
    private Long actStarNumber;
    private List<Long> starList;
    private Long taskId;

    private String taskName;
   //活动已完成多少天
    private long hadFinished;
  //活动还需要多少天
    private long needFinish;
    //活动内容
    private  String content;
    //活动开始时间
    private  String startTime;
    //活动结束时间
    private String endTime;
    //一同参加多少人
    private int personNum;
    
    private String status;
    
    private String feedBackWay;
    
    private String fileAddress;
    private String receiveBook;

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
    

    public Long getActStarNumber() {
		return actStarNumber;
	}

	public void setActStarNumber(Long actStarNumber) {
		this.actStarNumber = actStarNumber;
	}

	public int getStar() {
        return star;
    }

    
    public void setStar(int star) {
        this.star = star;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public long getHadFinished() {
        return hadFinished;
    }

    public void setHadFinished(long hadFinished) {
        this.hadFinished = hadFinished;
    }

    public long getNeedFinish() {
        return needFinish;
    }

    public void setNeedFinish(long needFinish) {
        this.needFinish = needFinish;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getPersonNum() {
        return personNum;
    }

    public void setPersonNum(int personNum) {
        this.personNum = personNum;
    }

    @Override
	public String toString() {
		return "TaskList [id=" + id + ", userName=" + userName + ", star="
				+ star + ", starNumber=" + starNumber + ", starList="
				+ starList + ", taskId=" + taskId + ", taskName=" + taskName
				+ ", hadFinished=" + hadFinished + ", needFinish=" + needFinish
				+ ", content=" + content + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", personNum=" + personNum
				+ ", status=" + status + ", feedBackWay=" + feedBackWay
				+ ", fileAddress=" + fileAddress + ", receiveBook="
				+ receiveBook + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFeedBackWay() {
		return feedBackWay;
	}

	public void setFeedBackWay(String feedBackWay) {
		this.feedBackWay = feedBackWay;
	}

	public List<Long> getStarList() {
		return starList;
	}

	public void setStarList(List<Long> list) {
		this.starList = list;
	}

	public Long getStarNumber() {
		return starNumber;
	}

	public void setStarNumber(Long starNumber) {
		this.starNumber = starNumber;
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
	
	
}
