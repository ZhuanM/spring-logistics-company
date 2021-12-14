package com.LogisticsCompany.api;

import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.service.UserService;
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

}
