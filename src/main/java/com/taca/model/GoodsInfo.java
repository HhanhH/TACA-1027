package com.taca.model;

import org.apache.ibatis.type.Alias;
import java.util.Date;

@Alias("GoodsInfo")
public class GoodsInfo {

    private Long id;

    private String type;

    private String category;

    private String name;

    private Long starNumber;

    private Long starLevel;

    private String iconAddress;

    private String status;

    private Long count;

    private Long availableStock;

    private Date createTime;

    private Date updateTime;

    private String description;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStarNumber() {
        return starNumber;
    }

    public void setStarNumber(Long starNumber) {
        this.starNumber = starNumber;
    }

    public Long getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(Long starLevel) {
        this.starLevel = starLevel;
    }

    public String getIconAddress() {
        return iconAddress;
    }

    public void setIconAddress(String iconAddress) {
        this.iconAddress = iconAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(Long availableStock) {
        this.availableStock = availableStock;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", starNumber=" + starNumber +
                ", starLevel=" + starLevel +
                ", iconAddress='" + iconAddress + '\'' +
                ", status='" + status + '\'' +
                ", count=" + count +
                ", availableStock=" + availableStock +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", description='" + description + '\'' +
                '}';
    }
}