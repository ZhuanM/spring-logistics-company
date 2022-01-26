package com.LogisticsCompany.service;

import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.Delivery;
import com.LogisticsCompany.repo.DeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        Delivery tmp;
        tmp = deliveryRepo.findBySender(delivery.getSender());
        System.out.println("--------------------------------------" + tmp + "-------------------------------");
        tmp.setRecipientAddress(delivery.getRecipientAddress());
        tmp.setCurrent_location(delivery.getCurrent_location());
        deliveryRepo.save(tmp);
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
    public List<String> getDeliveries() {
        List<Delivery> res = deliveryRepo.findAll();
//        string to test
        List<String> deliveries =
                res.stream()
                        .map(Delivery::toString)
                        .collect(Collectors.toList());

        return deliveries;

        //return deliveryRepo.findAll();
    }
}
