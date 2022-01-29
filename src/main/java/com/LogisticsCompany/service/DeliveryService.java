package com.LogisticsCompany.service;

import com.LogisticsCompany.dto.DeliveryDTO;
import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.Delivery;

import java.util.List;

public interface DeliveryService {
    Delivery saveDelivery(Delivery delivery);
    void updateDelivery(Delivery delivery);
    void deleteDelivery(Long id);
    Delivery getDelivery(Long id);
    List<Delivery> getDeliveries();
    DeliveryDTO convertToDTO(Delivery delivery);
    Delivery convertToEntity(DeliveryDTO deliveryDTO);
    List<Delivery> takeAllDeliveries();
    List<Delivery> takeAllDeliveriesRegisteredByEmployee(Long id);
    List<Delivery> takeAllDeliveriesThatAreNotReceived();
    List<Delivery> takeAllDeliveriesForCustomer(String sender);
}
