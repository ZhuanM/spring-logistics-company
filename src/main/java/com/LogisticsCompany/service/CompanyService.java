package com.LogisticsCompany.service;

import com.LogisticsCompany.dto.CompanyDTO;
import com.LogisticsCompany.entity.Company;

import java.time.LocalDate;
import java.util.List;

public interface CompanyService {
    Company saveCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(Long id);
    Company getCompany(Long id);
    List<Company> getCompanies();
    CompanyDTO convertToDTO(Company company);
    Company convertToEntity(CompanyDTO companyDTO);

    double profitFromTimePeriod(LocalDate start, LocalDate end);
}
