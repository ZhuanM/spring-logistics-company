package com.LogisticsCompany.repo;

import com.LogisticsCompany.entity.Company;
import com.LogisticsCompany.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepo extends JpaRepository<Office, Long> {
    Office findByAddress(String address);
}
