package com.yuan.foodtrace.auth.domain.command;

import com.yuan.foodtrace.auth.domain.request.VehicleUpdateRequest;

public class VehicleUpdateCommand {

    private Long id;
    private String brand;
    private String type;
    private String buyYear;
    private String license;
    private String company;
    private String operatorCompany;

    public static VehicleUpdateCommand fromRequest(VehicleUpdateRequest request, String operatorCompany) {
        return new VehicleUpdateCommand(
                request.getId(),
                request.getBrand(),
                request.getType(),
                request.getBuyYear(),
                request.getLicense(),
                request.getCompany(),
                operatorCompany
        );
    }

    private VehicleUpdateCommand(Long id, String brand, String type, String buyYear, String license, String company,
                                String operatorCompany) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.buyYear = buyYear;
        this.license = license;
        this.company = company;
        this.operatorCompany = operatorCompany;
    }

    public Long getId() {
        return id;
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

    public String getOperatorCompany() {
        return operatorCompany;
    }
}
