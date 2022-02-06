package com.LogisticsCompany.api;

import com.LogisticsCompany.entity.Company;
import com.LogisticsCompany.model.CompanyName;
import com.LogisticsCompany.service.CompanyService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    public CompanyName getCompanyName() {
        Company c = companyService.getCompany(1L);
        return new CompanyName(c.getName());
    }

    @GetMapping(path = "/profit")
    public BigDecimal getProfitBetween(@RequestParam String startDate, @RequestParam String endDate) {
        Company c = companyService.getCompany(1L);
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return BigDecimal.valueOf(companyService.profitFromTimePeriod(start, end));
    }
}
