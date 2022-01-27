package com.LogisticsCompany.service;

import com.LogisticsCompany.entity.Company;

import java.time.LocalDate;
import java.util.List;

public interface CompanyService {
    Company saveCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(Long id);
    Company getCompany(Long id);
    List<Company> getCompanies();

    double profitFromTimePeriod(LocalDate start, LocalDate end);
}
