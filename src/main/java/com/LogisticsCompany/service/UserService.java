package com.LogisticsCompany.service;

import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role roleName);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
