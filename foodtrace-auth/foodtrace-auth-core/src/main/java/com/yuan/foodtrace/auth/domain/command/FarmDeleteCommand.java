package com.yuan.foodtrace.auth.domain.command;

public class FarmDeleteCommand {

    private Long id;
    private String name;
    private String company;

    public FarmDeleteCommand(Long id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
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
}
