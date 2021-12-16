package com.LogisticsCompany.api;

import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.Role;
import com.LogisticsCompany.models.UserForm;
import com.LogisticsCompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path="/users")
    public List<AppUser> getAllUsers() {
        return userService.getUsers();
    }


    @PostMapping(path="/save_user")
    public AppUser saveUser(@RequestBody AppUser user) {
        //URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save_user").toUriString());
        System.out.println(user);
        //return ResponseEntity.created(uri).body(userService.saveUser(user));
        return userService.saveUser(user);
    }

    @GetMapping(path="/save_role")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save_role").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @GetMapping(path="/save")
    public void addRoleToUser(@RequestBody UserForm userForm) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save_role").toUriString());
        userService.addRoleToUser(userForm.getUsername(), userForm.getRoleName());
        ResponseEntity.ok().build();
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
}
