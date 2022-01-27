package com.LogisticsCompany.repo;

import com.LogisticsCompany.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery, Long> {
    Optional<Delivery> findById(Long id);
    Delivery findByName(String name);
}
