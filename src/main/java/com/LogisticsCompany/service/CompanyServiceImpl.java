package com.LogisticsCompany.service;

import com.LogisticsCompany.entity.Company;
import com.LogisticsCompany.entity.Delivery;
import com.LogisticsCompany.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private final CompanyRepo companyRepo;

    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepo.save(company);
    }

    @Override
    public void updateCompany(Company company) {
        //todo
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepo.deleteById(id);
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepo.getById(id);
    }

    @Override
    public List<Company> getCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public double profitFromTimePeriod(LocalDate start, LocalDate end) {
        List<Delivery> deliveries = companyRepo.profitFromTimePeriod(start, end);

        double total = 0;

        for (Delivery d : deliveries) {
            total += d.getPrice();
        }

        return total;
    }
}
