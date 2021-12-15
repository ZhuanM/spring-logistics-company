package com.LogisticsCompany.service;

import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.Role;
import com.LogisticsCompany.repo.RoleRepo;
import com.LogisticsCompany.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public AppUser saveUser(AppUser user) {
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role roleName) {
        return roleRepo.save(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.setRole(role.getName());
    }

    @Override
    public AppUser getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return userRepo.findAll();
    }
}
