package com.yuan.foodtrace.auth.domain.command;

import com.yuan.foodtrace.auth.domain.request.WorkerInsertRequest;

public class WorkerInsertCommand {

    private String name;
    private String idNumber;
    private String phoneNumber;
    private Integer age;
    private Boolean gender;
    private String company;
    private String operatorCompany;

    public static WorkerInsertCommand fromRequest(WorkerInsertRequest request, String operatorCompany) {
        return new WorkerInsertCommand(
                request.getName(),
                request.getIdNumber(),
                request.getPhoneNumber(),
                request.getAge(),
                request.getGender(),
                request.getCompany(),
                operatorCompany
        );
    }

    private WorkerInsertCommand(String name, String idNumber, String phoneNumber, Integer age, Boolean gender,
                                String company, String operatorCompany) {
        this.name = name;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = gender;
        this.company = company;
        this.operatorCompany = operatorCompany;
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

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOperatorCompany() {
        return operatorCompany;
    }
}
