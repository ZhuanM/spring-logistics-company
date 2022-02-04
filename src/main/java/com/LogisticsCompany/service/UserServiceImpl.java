package com.LogisticsCompany.service;

import com.LogisticsCompany.dto.AppUserDTO;
import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.RoleType;
import com.LogisticsCompany.repo.UserRepo;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
//@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepo.findByUsername(username);
        if(user == null) {
            System.out.println(("User not found id DB"));
            throw new UsernameNotFoundException("User not found id DB");
        }
        else {
            System.out.println(("User found id DB" + username));
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

        return new User(user.getUsername(), user.getPassword(), authorities);
    }

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

    @Override
    public AppUserDTO convertToDTO(AppUser user) {
        AppUserDTO userDTO = new AppUserDTO();
        if(user != null) {
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setEmail(user.getEmail());
            userDTO.setFullName(user.getFullName());
            userDTO.setPassword(user.getPassword());
            userDTO.setRole(user.getRole());
        }
        return userDTO;
    }

    @Override
    public AppUser convertToEntity(AppUserDTO userDTO) {
        AppUser user = new AppUser();
        if(userDTO != null) {
            user.setId(userDTO.getId());
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setFullName(userDTO.getFullName());
            user.setPassword(userDTO.getPassword());
            user.setRole(userDTO.getRole());
        }
        return user;
    }

    @Override
    public List<AppUser> getAllEmployees() { return userRepo.getAllEmployees(); }

    @Override
    public List<AppUser> getAllCustomers() { return userRepo.getAllCustomers(); }
}
