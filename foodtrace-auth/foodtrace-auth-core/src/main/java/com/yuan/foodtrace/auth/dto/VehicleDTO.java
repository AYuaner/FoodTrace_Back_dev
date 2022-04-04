package com.yuan.foodtrace.auth.dto;

import java.io.Serializable;

public class VehicleDTO implements Serializable {

    private String id;
    private String brand;
    private String type;
    private String buyYear;
    private String license;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBuyYear() {
        return buyYear;
    }

    public void setBuyYear(String buyYear) {
        this.buyYear = buyYear;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
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
        com.yuan.foodtrace.auth.entity.VehicleRecord other = (com.yuan.foodtrace.auth.entity.VehicleRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getBrand() == null ? other.getBrand() == null : this.getBrand().equals(other.getBrand()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getBuyYear() == null ? other.getBuyYear() == null : this.getBuyYear().equals(other.getBuyYear()))
                && (this.getLicense() == null ? other.getLicense() == null : this.getLicense().equals(other.getLicense()));
    }

    @Override
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