package com.yuan.foodtrace.auth.domain.command;

import com.yuan.foodtrace.auth.domain.request.FarmDeleteRequest;

public class FarmDeleteCommand {

    private Long id;
    private String name;
    private String operatorCompany;

    public static FarmDeleteCommand fromRequest(FarmDeleteRequest request, String operatorCompany) {
        return new FarmDeleteCommand(
                request.getId(),
                request.getName(),
                operatorCompany
        );
    }

    private FarmDeleteCommand(Long id, String name, String operatorCompany) {
        this.id = id;
        this.name = name;
        this.operatorCompany = operatorCompany;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOperatorCompany() {
        return operatorCompany;
    }
}
