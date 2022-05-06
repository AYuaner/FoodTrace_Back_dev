package com.yuan.foodtrace.auth.domain.command;

import com.yuan.foodtrace.auth.domain.request.FarmUpdateRequest;

public class FarmUpdateCommand {

    private Long id;
    private String name;
    private String company;
    private String location;
    private String operatorCompany;

    public static FarmUpdateCommand fromRequest(FarmUpdateRequest request, String operatorCompany) {
        return new FarmUpdateCommand(
                request.getId(),
                request.getName(),
                request.getCompany(),
                request.getLocation(),
                operatorCompany
        );
    }

    private FarmUpdateCommand(Long id, String name, String company, String location, String operatorCompany) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.location = location;
        this.operatorCompany = operatorCompany;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getOperatorCompany() {
        return operatorCompany;
    }
}
