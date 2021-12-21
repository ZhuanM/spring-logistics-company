package com.LogisticsCompany.service;

import com.LogisticsCompany.entity.AppUser;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    void updateUser(AppUser user);
    void deleteUser(Long id);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
