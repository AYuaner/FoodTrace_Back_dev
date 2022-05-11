package com.yuan.foodtrace.auth.domain.command;

import com.yuan.foodtrace.auth.domain.request.WorkerDeleteRequest;

public class WorkerDeleteCommand {

    private Long id;
    private String idNumber;
    private String operatorCompany;

    public static WorkerDeleteCommand fromRequest(WorkerDeleteRequest request, String operatorCompany) {
        return new WorkerDeleteCommand(
                request.getId(),
                request.getIdNumber(),
                operatorCompany
        );
    }

    private WorkerDeleteCommand(Long id, String idNumber, String operatorCompany) {
        this.id = id;
        this.idNumber = idNumber;
        this.operatorCompany = operatorCompany;
    }

    public Long getId() {
        return id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getOperatorCompany() {
        return operatorCompany;
    }
}
