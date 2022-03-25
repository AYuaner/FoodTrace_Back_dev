package com.yuan.foodtrace.fabric.entity;

/**
 * 播种信息
 *
 * @author A_Yuan
 */
public class SeedInfo {

    /**
     * 作物ID : PrimaryKey
     */
    private String cropsId;
    /**
     * 作物名称
     */
    private String cropsName;
    /**
     * 所在地
     */
    private String address;
    /**
     * 播种时间
     */
    private String seedTime;
    /**
     * 创建时间
     */
    private String createdTime;
    /**
     * 所属农场ID
     */
    private String farmId;
    /**
     * 所属农场
     */
    private String farmName;
    /**
     * 操作员ID
     */
    private String operatorId;
    /**
     * 操作员姓名
     */
    private String operatorName;
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

    public String getCropsName() {
        return cropsName;
    }

    public void setCropsName(String cropsName) {
        this.cropsName = cropsName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSeedTime() {
        return seedTime;
    }

    public void setSeedTime(String seedTime) {
        this.seedTime = seedTime;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getFarmId() {
        return farmId;
    }

    public void setFarmId(String farmId) {
        this.farmId = farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "SeedInfo{" +
                "cropsId='" + cropsId + '\'' +
                ", cropsName='" + cropsName + '\'' +
                ", address='" + address + '\'' +
                ", seedTime='" + seedTime + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", farmId='" + farmId + '\'' +
                ", farmName='" + farmName + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
