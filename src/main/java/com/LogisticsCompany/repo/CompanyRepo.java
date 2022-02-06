package com.LogisticsCompany.repo;

import com.LogisticsCompany.entity.Company;
import com.LogisticsCompany.entity.Delivery;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {
    Optional<Company> findById(Long aLong);
    Company findBySymbol(String symbol);

    @Query("SELECT d FROM Delivery d WHERE d.status = 'DELIVERED' AND d.ETA >= ?1 AND d.ETA <= ?2")
    List<Delivery> profitFromTimePeriod(LocalDate start, LocalDate end);
}
