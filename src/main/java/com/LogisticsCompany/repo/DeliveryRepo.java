package com.LogisticsCompany.repo;

import com.LogisticsCompany.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery, Long> {
    Optional<Delivery> findById(Long id);
    Delivery findByName(String name);

    @Query("SELECT d FROM Delivery d")
    List<Delivery> takeAllDeliveries();

    @Query("SELECT d FROM Delivery d JOIN d.registeredBy r WHERE r.id = ?1")
    List<Delivery> takeAllDeliveriesRegisteredByEmployee(Long id);

    @Query("SELECT d FROM Delivery d WHERE d.status = 'IN_OFFICE' OR d.status = 'IN_COURIER'")
    List<Delivery> takeAllDeliveriesThatAreNotReceived();

    @Query("SELECT d FROM Delivery d WHERE d.senderUsername = ?1")
    List<Delivery> takeAllDeliveriesForCustomer( String sender);
}
