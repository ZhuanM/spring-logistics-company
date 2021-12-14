package com.LogisticsCompany.service;

import com.LogisticsCompany.entity.AppUser;
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
public class UserImpl implements UserService {
    private final UserRepo userRepo;
    //private final RoleRepo roleRepo;


    public UserImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public AppUser saveUser(AppUser user) {
        return userRepo.save(user);
    }

//    @Override
//    public Role saveRole(Role role) {
//        return roleRepo.save(role);
//    }

//    @Override
//    public void addRoleToUser(String username, String roleName) {
//        AppUser user = userRepo.findByUsername(username);
//        Role role = roleRepo.findByName(roleName);
//        user.getRole().add(role);
//    }

    @Override
    public AppUser getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return userRepo.findAll();
    }
}
