package com.LogisticsCompany.service;

import com.LogisticsCompany.entity.AppUser;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
