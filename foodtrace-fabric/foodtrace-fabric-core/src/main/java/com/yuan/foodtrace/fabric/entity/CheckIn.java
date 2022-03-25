package com.yuan.foodtrace.fabric.entity;

/**
 * 入库记录
 *
 * @author A_Yuan
 */
public class CheckIn {

    /**
     * 作物ID
     */
    private String cropsId;
    /**
     * 经销商
     */
    private String company;
    /**
     * 位置
     */
    private String location;
    /**
     * 入库核对人员ID
     */
    private String operatorId;
    /**
     * 核对人员姓名
     */
    private String operatorName;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
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
        return "CheckIn{" +
                "cropsId='" + cropsId + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
