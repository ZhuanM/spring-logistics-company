package com.LogisticsCompany.service;

import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.RoleType;
import com.LogisticsCompany.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepo userRepo;

   public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
   }

    @Override
    public AppUser saveUser(AppUser user) throws ConstraintViolationException {
       // if(userRepo.findByUsername(user.getUsername()) == null)
            return userRepo.save(user);
        //else throw new ConstraintViolationException("Username already exists!");
    }

    @Override
    public void updateUser(AppUser user) {
        AppUser tmp;
        tmp = userRepo.findByUsername(user.getUsername());
        tmp.setEmail(user.getEmail());
        tmp.setFullName(user.getFullName());
        tmp.setPassword(user.getPassword());
        userRepo.save(tmp);
    }

    @Override
    public void deleteUser(Long id) {
       //AppUser tmp = userRepo.findByUsername(username);
       userRepo.deleteById(id);
    }


    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = userRepo.findByUsername(username);
        user.setRole(RoleType.valueOf(roleName));
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
