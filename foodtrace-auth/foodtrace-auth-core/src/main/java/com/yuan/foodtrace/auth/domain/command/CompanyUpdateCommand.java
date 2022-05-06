package com.yuan.foodtrace.auth.domain.command;

import com.yuan.foodtrace.auth.domain.request.CompanyUpdateRequest;

public class CompanyUpdateCommand {

    private Long id;
    private String name;

    public static CompanyUpdateCommand fromRequest(CompanyUpdateRequest request) {
        return new CompanyUpdateCommand(
                request.getId(),
                request.getName()
        );
    }

    private CompanyUpdateCommand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
