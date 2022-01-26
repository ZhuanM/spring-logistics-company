package com.LogisticsCompany.service;

import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.Delivery;

import java.util.List;

public interface DeliveryService {
    Delivery saveDelivery(Delivery delivery);
    void updateDelivery(Delivery delivery);
    void deleteDelivery(Long id);
    Delivery getDelivery(Long id);
    List<String> getDeliveries();
}
