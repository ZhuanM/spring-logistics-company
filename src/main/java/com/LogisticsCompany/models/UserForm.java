package com.LogisticsCompany.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Builder
public class UserForm{
    private String username;
    private String roleName;

    public String getUsername() {
        return username;
    }

    public String getRoleName() {
        return roleName;
    }
}