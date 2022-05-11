package com.yuan.foodtrace.auth.domain.command;

import com.yuan.foodtrace.auth.domain.request.CompanyInsertRequest;

public class CompanyInsertCommand {

    private String name;

    public static CompanyInsertCommand fromRequest(CompanyInsertRequest request) {
        return new CompanyInsertCommand(
                request.getName()
        );
    }

    private CompanyInsertCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
