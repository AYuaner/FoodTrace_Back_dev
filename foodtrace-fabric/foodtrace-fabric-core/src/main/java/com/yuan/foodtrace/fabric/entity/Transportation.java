package com.yuan.foodtrace.fabric.entity;

/**
 * 运输信息
 *
 * @author A_Yuan
 */
public class Transportation {

    /**
     * 作物ID
     */
    private String cropsId;
    /**
     * 运输公司
     */
    private String company;
    /**
     * 开始位置
     */
    private String startLocation;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束位置
     */
    private String endLocation;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 运输车辆
     */
    private String vehicle;
    /**
     * 驾驶员
     */
    private String driver;
    /**
     * 记录时间
     */
    private String createdTime;
    /**
     * 备注
     */
    private String remarks;

    public String getCropsId() {
        return cropsId;
    }

    public void setCropsId(String cropsId) {
        this.cropsId = cropsId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "cropsId='" + cropsId + '\'' +
                ", company='" + company + '\'' +
                ", startLocation='" + startLocation + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endLocation='" + endLocation + '\'' +
                ", endTime='" + endTime + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", driver='" + driver + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
