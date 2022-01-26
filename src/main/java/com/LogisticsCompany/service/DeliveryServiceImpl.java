package com.LogisticsCompany.service;

import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.Delivery;
import com.LogisticsCompany.repo.DeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService{

    @Autowired
    private final DeliveryRepo deliveryRepo;

    public DeliveryServiceImpl(DeliveryRepo deliveryRepo) {
        this.deliveryRepo = deliveryRepo;
    }

    @Override
    public Delivery saveDelivery(Delivery delivery) {
        return deliveryRepo.save(delivery);
    }

    @Override
    public void updateDelivery(Delivery delivery) {
        //todo
    }

    @Override
    public void deleteDelivery(Long id) {
        deliveryRepo.deleteById(id);
    }

    @Override
    public Delivery getDelivery(Long id) {
        return deliveryRepo.getById(id);
    }

    @Override
    public List<Delivery> getDeliveries() {
        return deliveryRepo.findAll();
    }
}
