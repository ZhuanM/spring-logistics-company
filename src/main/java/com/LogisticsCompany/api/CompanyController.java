package com.LogisticsCompany.api;

import com.LogisticsCompany.entity.Company;
import com.LogisticsCompany.service.CompanyService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@CrossOrigin(origins = "http://localhost:4202")
@RestController
@RequestMapping(path = "/api/company")
public class CompanyController {

    @Autowired
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(path = "/name")
    public String getCompanyName() {
        Company c = companyService.getCompany(1L);
        return c.getName();
    }

    @GetMapping(path = "/profit")
    public double getProfitBetween(@RequestParam String start, @RequestParam String end) {
        Company c = companyService.getCompany(1L);
        LocalDate startDate = LocalDate.parse(start, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate = LocalDate.parse(end, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return companyService.profitFromTimePeriod(startDate, endDate);
    }
}
