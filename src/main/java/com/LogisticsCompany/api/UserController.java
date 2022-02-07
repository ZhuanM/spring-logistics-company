package com.LogisticsCompany.api;

import com.LogisticsCompany.config.JwtUtility;
import com.LogisticsCompany.dto.AppUserDTO;
import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.RoleType;
import com.LogisticsCompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4202")
@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path="")
    public String greet() {
        return "NBU Logistics Company";
    }

    @PostMapping(path="/register")
    public void register(@RequestBody AppUserDTO userDTO) throws Exception {
        AppUser user = userService.convertToEntity(userDTO);
        userService.saveUser(user);
    }

    @GetMapping(path="/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        AppUser user = userService.getUser(username);
        if(user == null || !user.getPassword().equals(password)) {
            return "Invalid user or password!";
        }
        else {
            return "Login successful! Welcome back, " + user.getFullName() + "!";
        }
    }

    @PostMapping(path="/update")
    public void update(@RequestBody AppUser user) {
        userService.updateUser(user);
        //return "Successfully updated user with username: " + user.getUsername();
    }

    @DeleteMapping(path="/delete")
    public void delete(@RequestParam String username) {
        AppUser user = userService.getUser(username);
        if(user != null) {
            userService.deleteUser(user.getId());
            //return "User " + user.getUsername() + " successfully deleted!";
        }
//        else {
//            return "User " + username + " does not exist!";
//        }
    }

    @GetMapping(path="/user")
    public AppUserDTO getDelivery(@RequestParam String username) {
        AppUser user = userService.getUser(username);
        if(user == null) {
            return new AppUserDTO();
        }
        else {
            return userService.convertToDTO(user);
        }
    }

    @GetMapping(path="/all")
    public List<AppUser> getAllUsers() {
        return userService.getUsers();
    } //using userService.findAll();???

    @GetMapping(path = "/employees")
    public List<AppUser> getAllEmployees() {
        return userService.getAllEmployees();
    }

    @GetMapping(path = "/customers")
    public List<AppUser> getAllCustomers() {
        return userService.getAllCustomers();
    }

}
