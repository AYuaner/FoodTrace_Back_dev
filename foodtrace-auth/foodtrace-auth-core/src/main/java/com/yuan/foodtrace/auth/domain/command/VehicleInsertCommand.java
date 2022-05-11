package com.yuan.foodtrace.auth.domain.command;

import com.yuan.foodtrace.auth.domain.request.VehicleInsertRequest;

public class VehicleInsertCommand {

    private String brand;
    private String type;
    private String buyYear;
    private String license;
    private String company;
    private String operatorCompany;

    public static VehicleInsertCommand fromRequest(VehicleInsertRequest request, String operatorCompany) {
        return new VehicleInsertCommand(
                request.getBrand(),
                request.getType(),
                request.getBuyYear(),
                request.getLicense(),
                request.getCompany(),
                operatorCompany
        );
    }

    private VehicleInsertCommand(String brand, String type, String buyYear, String license, String company,
                                 String operatorCompany) {
        this.brand = brand;
        this.type = type;
        this.buyYear = buyYear;
        this.license = license;
        this.company = company;
        this.operatorCompany = operatorCompany;
    }

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

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOperatorCompany() {
        return operatorCompany;
    }
}
