package com.LogisticsCompany.api;

import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.Role;
import com.LogisticsCompany.entity.UserForm;
import com.LogisticsCompany.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/")
//@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path="/users")
    public List<AppUser> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping(path="/save_user")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save_user").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
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
}
