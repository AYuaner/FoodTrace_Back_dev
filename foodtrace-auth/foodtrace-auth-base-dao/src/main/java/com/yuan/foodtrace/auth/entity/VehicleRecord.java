package com.yuan.foodtrace.auth.entity;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table vehicle
 */
public class VehicleRecord implements Serializable {
    /**
     * Database Column Remarks:
     *   车辆标识码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.id")
    private String id;

    /**
     * Database Column Remarks:
     *   品牌
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.brand")
    private String brand;

    /**
     * Database Column Remarks:
     *   车辆型号
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.type")
    private String type;

    /**
     * Database Column Remarks:
     *   购买年份
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.buy_year")
    private String buyYear;

    /**
     * Database Column Remarks:
     *   车牌
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.license")
    private String license;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.id")
    public String getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.id")
    public void setId(String id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.brand")
    public String getBrand() {
        return brand;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.type")
    public String getType() {
        return type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.type")
    public void setType(String type) {
        this.type = type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.buy_year")
    public String getBuyYear() {
        return buyYear;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.buy_year")
    public void setBuyYear(String buyYear) {
        this.buyYear = buyYear;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.license")
    public String getLicense() {
        return license;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: vehicle.license")
    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
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
        VehicleRecord other = (VehicleRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBrand() == null ? other.getBrand() == null : this.getBrand().equals(other.getBrand()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getBuyYear() == null ? other.getBuyYear() == null : this.getBuyYear().equals(other.getBuyYear()))
            && (this.getLicense() == null ? other.getLicense() == null : this.getLicense().equals(other.getLicense()));
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: vehicle")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBrand() == null) ? 0 : getBrand().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getBuyYear() == null) ? 0 : getBuyYear().hashCode());
        result = prime * result + ((getLicense() == null) ? 0 : getLicense().hashCode());
        return result;
    }
}