package com.yuan.foodtrace.auth.domain.request;

public class VehicleInsertRequest {

    private String brand;
    private String type;
    private String buyYear;
    private String license;
    private String company;

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getBuyYear() {
        return buyYear;
    }

    public String getLicense() {
        return license;
    }

    public String getCompany() {
        return company;
    }
}
