package com.LogisticsCompany.dto;

import com.LogisticsCompany.entity.Delivery;
import com.LogisticsCompany.entity.RoleType;

import java.util.Set;
import java.util.TreeSet;

public class AppUserDTO {

    private Long id;
    private String username;
    private String email;
    private String fullName;
    private String password;
    private RoleType role;

    public AppUserDTO() {
    }

    public AppUserDTO(Long id, String username, String email, String fullName, String password, RoleType role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public RoleType getRole() {
        return role;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AppUserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
