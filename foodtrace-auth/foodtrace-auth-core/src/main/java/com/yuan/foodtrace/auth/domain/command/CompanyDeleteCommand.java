package com.yuan.foodtrace.auth.domain.command;

import com.yuan.foodtrace.auth.domain.request.CompanyDeleteRequest;

public class CompanyDeleteCommand {

    private Long id;
    private String name;

    public static CompanyDeleteCommand fromRequest(CompanyDeleteRequest request) {
        return new CompanyDeleteCommand(
                request.getId(),
                request.getName()
        );
    }

    private CompanyDeleteCommand(Long id, String name) {
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
