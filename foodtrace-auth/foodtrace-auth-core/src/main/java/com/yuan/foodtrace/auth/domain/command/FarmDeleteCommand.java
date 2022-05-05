package com.yuan.foodtrace.auth.domain.command;

public class FarmDeleteCommand {

    private String id;
    private String name;
    private String company;

    public FarmDeleteCommand(String id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
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
}
