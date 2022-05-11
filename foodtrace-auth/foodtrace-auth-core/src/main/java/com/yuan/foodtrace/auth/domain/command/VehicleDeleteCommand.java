package com.yuan.foodtrace.auth.domain.command;

import com.yuan.foodtrace.auth.domain.request.VehicleDeleteRequest;

public class VehicleDeleteCommand {

    private Long id;
    private String license;
    private String operatorCompany;

    public static VehicleDeleteCommand fromRequest(VehicleDeleteRequest request, String operatorCompany) {
        return new VehicleDeleteCommand(request.getId(), request.getLicense(), operatorCompany);
    }

    private VehicleDeleteCommand(Long id, String license, String operatorCompany) {
        this.id = id;
        this.license = license;
        this.operatorCompany = operatorCompany;
    }

    public Long getId() {
        return id;
    }

    public String getLicense() {
        return license;
    }

    public String getOperatorCompany() {
        return operatorCompany;
    }
}
