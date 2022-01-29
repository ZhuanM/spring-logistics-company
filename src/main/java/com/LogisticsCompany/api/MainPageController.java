package com.LogisticsCompany.api;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class MainPageController {

    @GetMapping(path = "")
    public String greet() {
        return "Main page of NBU Logistics Company";
    }
}
