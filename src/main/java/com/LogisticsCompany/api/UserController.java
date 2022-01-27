package com.LogisticsCompany.api;

import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping(path="/")
    public String greet() {
        return "NBU Logistics Company";
    }

    @GetMapping(path="/users")
    public List<AppUser> getAllUsers() {
        return userService.getUsers();
    } //using userService.findAll();???

    @PostMapping(path="/register")
    public AppUser saveUser(@RequestBody AppUser user) {
        System.out.println(user);
        return userService.saveUser(user);
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

    @PutMapping(path="/update")
    public String update(@RequestBody AppUser user) {
        userService.updateUser(user);
        return "Successfully updated user with username: " + user.getUsername();
    }

    @PutMapping(path="/update")
    public AppUser updateUser(@RequestBody AppUser user, @PathVariable ("username") String username){
        user = userService.getUser(username);
        user.setFullName(user.getFullName());
        user.setEmail(user.getEmail());
        return this.userService.saveUser(user);
    }

    @DeleteMapping(path="/delete")
    public String delete(@RequestParam String username) {
        AppUser user = userService.getUser(username);
        if(user != null) {
            userService.deleteUser(user.getId());
            return "User " + user.getUsername() + " successfully deleted!";
        }
        else {
            return "User " + username + " does not exist!";
        }
    }

   /*     @GetMapping(path="/save")
    public void addRoleToUser(@RequestBody UseForm userForm) {

        userService.addRoleToUser(userForm.getUsername(), userForm.getRoleName());

    }*/

    }
    @Data
    class UseForm{
        private String username;
        private String roleName;
}
