package com.yuan.foodtrace.fabric.entity;

/**
 * 成长期记录：施肥、除草、驱虫等
 *
 * @author A_Yuan
 */
public class GrowInfo {

    /**
     * 操作流水号ID
     */
    private String operationId;
    /**
     * 作物ID
     */
    private String cropsId;
    /**
     * 操作类型
     */
    private String operateType;
    /**
     * 操作时间
     */
    private String operateTime;
    /**
     * 操作员ID
     */
    private String operatorId;
    /**
     * 操作员姓名
     */
    private String operatorName;
    /**
     * 工具
     */
    private String tools;
    /**
     * 记录时间
     */
    private String createdTime;
    /**
     * 备注
     */
    private String remarks;

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getCropsId() {
        return cropsId;
    }

    public void setCropsId(String cropsId) {
        this.cropsId = cropsId;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
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

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
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
        return "GrowInfo{" +
                "operationId='" + operationId + '\'' +
                ", cropsId='" + cropsId + '\'' +
                ", operateType='" + operateType + '\'' +
                ", operateTime='" + operateTime + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", tools='" + tools + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
