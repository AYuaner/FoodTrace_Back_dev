package com.yuan.foodtrace.auth.domain.command;

public class FarmInsertCommand {

    private String name;
    private String company;
    private String location;

    public FarmInsertCommand(String name, String company, String location) {
        this.name = name;
        this.company = company;
        this.location = location;
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
}
