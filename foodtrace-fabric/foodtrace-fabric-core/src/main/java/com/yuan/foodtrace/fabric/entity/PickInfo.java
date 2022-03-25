package com.yuan.foodtrace.fabric.entity;

/**
 * 采摘信息
 *
 * @author A_Yuan
 */
public class PickInfo {

    /**
     * 作物ID
     */
    private String cropsId;
    /**
     * 采摘时间
     */
    private String operateTime;
    /**
     * 采摘者ID
     */
    private String operatorId;
    /**
     * 采摘者姓名
     */
    private String operatorName;
    /**
     * 创建时间
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

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
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
        return "PickInfo{" +
                "cropsId='" + cropsId + '\'' +
                ", operateTime='" + operateTime + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
