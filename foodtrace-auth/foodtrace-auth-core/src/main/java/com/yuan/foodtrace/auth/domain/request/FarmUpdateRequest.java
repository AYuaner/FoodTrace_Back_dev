package com.yuan.foodtrace.auth.domain.request;

public class FarmUpdateRequest {

    private String id;
    private String name;
    private String company;
    private String location;

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
}
