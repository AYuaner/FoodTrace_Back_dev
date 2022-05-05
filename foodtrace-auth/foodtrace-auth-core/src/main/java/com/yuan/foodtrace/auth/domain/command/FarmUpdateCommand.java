package com.yuan.foodtrace.auth.domain.command;

public class FarmUpdateCommand {

    private String id;
    private String name;
    private String company;
    private String location;
    private String operatorCompany;

    public FarmUpdateCommand(String id, String name, String company, String location, String operatorCompany) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.location = location;
        this.operatorCompany = operatorCompany;
    }

    public String getId() {
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
