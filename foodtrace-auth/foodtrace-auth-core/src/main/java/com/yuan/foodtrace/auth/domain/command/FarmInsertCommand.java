package com.yuan.foodtrace.auth.domain.command;

import com.yuan.foodtrace.auth.domain.request.FarmInsertRequest;

public class FarmInsertCommand {

    private String name;
    private String company;
    private String location;
    private String operatorCompany;

    public static FarmInsertCommand fromRequest(FarmInsertRequest request, String operatorCompany) {
        return new FarmInsertCommand(
                request.getName(),
                request.getCompany(),
                request.getLocation(),
                operatorCompany
        );
    }

    private FarmInsertCommand(String name, String company, String location, String operatorCompany) {
        this.name = name;
        this.company = company;
        this.location = location;
        this.operatorCompany = operatorCompany;
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
