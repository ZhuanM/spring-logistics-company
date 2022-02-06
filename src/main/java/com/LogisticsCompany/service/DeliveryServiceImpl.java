package com.LogisticsCompany.service;

import com.LogisticsCompany.dto.DeliveryDTO;
import com.LogisticsCompany.entity.Delivery;
import com.LogisticsCompany.repo.DeliveryRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService{

    @Autowired
    private final DeliveryRepo deliveryRepo;
    @Autowired
    private final CompanyService companyService;
    @Autowired
    private final UserService userService;

    public DeliveryServiceImpl(DeliveryRepo deliveryRepo, CompanyService companyService, UserService userService) {
        this.deliveryRepo = deliveryRepo;
        this.companyService = companyService;
        this.userService = userService;
    }

    @Override
    public Delivery saveDelivery(Delivery delivery) {
        return deliveryRepo.save(delivery);
    }

    @Override
    public void updateDelivery(Delivery delivery) {
        Delivery tmp;
        tmp = deliveryRepo.findByName(delivery.getName());
        //tmp.setRecipientAddress(delivery.getRecipientAddress());
        tmp.setRecipient(delivery.getRecipient());
        tmp.setSentDate(delivery.getSentDate());
        tmp.setETA(delivery.getETA());
        tmp.setStatus(delivery.getCurrent_location());
        tmp.setPrice(delivery.getPrice());
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
    public List<Delivery> getDeliveries() {
        return deliveryRepo.findAll();
    }

    @Override
    public DeliveryDTO convertToDTO(Delivery delivery) {
        DeliveryDTO deliveryDTO = new DeliveryDTO();
        if(delivery != null) {
            deliveryDTO.setId(delivery.getId());
            deliveryDTO.setName(delivery.getName());
            deliveryDTO.setCompany(companyService.convertToDTO(delivery.getCompany()));
            deliveryDTO.setRegisteredBy(userService.convertToDTO(delivery.getRegisteredBy()));
            deliveryDTO.setSenderUsername(delivery.getSenderUsername());
            deliveryDTO.setRecipient(delivery.getRecipient());
            deliveryDTO.setStatus(delivery.getStatus());
            deliveryDTO.setRecipientAddress(delivery.getRecipientAddress());
            deliveryDTO.setSentDate(delivery.getSentDate());
            deliveryDTO.setETA(delivery.getETA());
            deliveryDTO.setWeight(delivery.getWeight());
            deliveryDTO.setPrice(delivery.getPrice());
        }
        return deliveryDTO;
    }

    @Override
    public Delivery convertToEntity(DeliveryDTO deliveryDTO) {
        Delivery delivery = new Delivery();
        if(deliveryDTO != null) {
            delivery.setId(deliveryDTO.getId());
            delivery.setName(deliveryDTO.getName());
            delivery.setCompany(companyService.convertToEntity(deliveryDTO.getCompany()));
            delivery.setRegisteredBy(userService.convertToEntity(deliveryDTO.getRegisteredBy()));
            delivery.setSenderUsername(deliveryDTO.getSenderUsername());
            delivery.setRecipient(deliveryDTO.getRecipient());
            delivery.setStatus(deliveryDTO.getStatus());
            delivery.setRecipientAddress(deliveryDTO.getRecipientAddress());
            delivery.setSentDate(deliveryDTO.getSentDate());
            delivery.setETA(deliveryDTO.getETA());
            delivery.setWeight(deliveryDTO.getWeight());
            delivery.setPrice(deliveryDTO.getPrice());
        }
        return delivery;
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
