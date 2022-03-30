package com.yuan.foodtrace.auth.entity;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table worker
 */
public class WorkerRecord implements Serializable {
    /**
     * Database Column Remarks:
     *   工人 ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.id")
    private String id;

    /**
     * Database Column Remarks:
     *   姓名
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.name")
    private String name;

    /**
     * Database Column Remarks:
     *   身份证号码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.id_number")
    private String idNumber;

    /**
     * Database Column Remarks:
     *   手机号
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.phone_number")
    private String phoneNumber;

    /**
     * Database Column Remarks:
     *   年龄
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.age")
    private Integer age;

    /**
     * Database Column Remarks:
     *   性别
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.gender")
    private Boolean gender;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.id")
    public String getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.id")
    public void setId(String id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.id_number")
    public String getIdNumber() {
        return idNumber;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.id_number")
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.phone_number")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.age")
    public Integer getAge() {
        return age;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.gender")
    public Boolean getGender() {
        return gender;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: worker.gender")
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WorkerRecord other = (WorkerRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIdNumber() == null ? other.getIdNumber() == null : this.getIdNumber().equals(other.getIdNumber()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()));
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: worker")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIdNumber() == null) ? 0 : getIdNumber().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        return result;
    }
}