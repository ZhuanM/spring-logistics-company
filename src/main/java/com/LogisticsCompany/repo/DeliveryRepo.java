package com.LogisticsCompany.repo;


import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepo extends JpaRepository<Delivery, Long> {
}
