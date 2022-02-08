package com.LogisticsCompany.service;

import com.LogisticsCompany.dto.AppUserDTO;
import com.LogisticsCompany.entity.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    AppUser saveUser(AppUser user);
    void updateUser(AppUser user);
    void deleteUser(Long id);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
    AppUserDTO convertToDTO(AppUser user);
    AppUser convertToEntity(AppUserDTO userDTO);
    List<AppUser> getAllEmployees();
    List<AppUser> getAllCustomers();
}
