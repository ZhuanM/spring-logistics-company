package com.LogisticsCompany.api;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/home")
public class MainPageController {

    @GetMapping(path="/home")
    public String greet() {
        return "NBU Logistics Company";
    }
}
