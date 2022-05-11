package com.yuan.foodtrace.auth.domain.request;

public class WorkerUpdateRequest {

    private Long id;
    private String name;
    private String idNumber;
    private String phoneNumber;
    private Integer age;
    private Boolean gender;
    private String company;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getGender() {
        return gender;
    }

    public String getCompany() {
        return company;
    }
}
