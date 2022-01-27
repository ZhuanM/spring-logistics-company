package com.LogisticsCompany.service;

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
        tmp = deliveryRepo.findByName(delivery.getName());
        tmp.setRecipientAddress(delivery.getRecipientAddress());
        tmp.setStatus(delivery.getCurrent_location());
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

    @Override
    public List<Delivery> takeAllDeliveries() { return deliveryRepo.takeAllDeliveries(); }

    @Override
    public List<Delivery> takeAllDeliveriesRegisteredByEmployee(Long id) { return deliveryRepo.takeAllDeliveriesRegisteredByEmployee(id); }

    @Override
    public List<Delivery> takeAllDeliveriesThatAreNotReceived() { return deliveryRepo.takeAllDeliveriesThatAreNotReceived(); }

    @Override
    public List<Delivery> takeAllDeliveriesForCustomer(String sender) { return deliveryRepo.takeAllDeliveriesForCustomer(sender); }

}
