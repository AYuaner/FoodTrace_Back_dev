package com.yuan.foodtrace.auth.domain.command;

import com.yuan.foodtrace.auth.domain.request.WorkerUpdateRequest;

public class WorkerUpdateCommand {

    private Long id;
    private String name;
    private String idNumber;
    private String phoneNumber;
    private Integer age;
    private Boolean gender;
    private String company;
    private String operatorCompany;

    public static WorkerUpdateCommand fromRequest(WorkerUpdateRequest request,String operatorCompany) {
        return new WorkerUpdateCommand(
                request.getId(),
                request.getName(),
                request.getIdNumber(),
                request.getPhoneNumber(),
                request.getAge(),
                request.getGender(),
                request.getCompany(),
                operatorCompany
        );
    }

    private WorkerUpdateCommand(Long id, String name, String idNumber, String phoneNumber, Integer age, Boolean gender,
                               String company, String operatorCompany) {
        this.id = id;
        this.name = name;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = gender;
        this.company = company;
        this.operatorCompany = operatorCompany;
    }

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

    public String getOperatorCompany() {
        return operatorCompany;
    }
}
