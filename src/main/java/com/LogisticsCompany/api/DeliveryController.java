package com.LogisticsCompany.api;

import com.LogisticsCompany.dto.DeliveryDTO;
import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.Company;
import com.LogisticsCompany.entity.Delivery;
import com.LogisticsCompany.service.CompanyService;
import com.LogisticsCompany.service.DeliveryService;
import com.LogisticsCompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4202")
@RestController
@RequestMapping(path = "/api/deliveries")
public class DeliveryController {

    @Autowired
    private final DeliveryService deliveryService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final CompanyService companyService;

    public DeliveryController(DeliveryService deliveryService, UserService userService, CompanyService companyService) {
        this.deliveryService = deliveryService;
        this.userService = userService;
        this.companyService = companyService;
    }

    @GetMapping(path="")
    public String greet() {
        return "Page for deliveries of NBU Logistics Company";
    }

    @PostMapping(path="/save")
    public DeliveryDTO saveDelivery(@RequestBody Delivery delivery) {
        AppUser user = userService.getUser(delivery.getRegisteredBy().getUsername());
        Company company = companyService.getCompany(delivery.getCompany().getId());

        Delivery tmp = new Delivery(null,
                company,
                user,
                delivery.getSenderUsername(),
                delivery.getRecipient(),
                delivery.getCurrent_location(),
                delivery.getRecipientAddress(),
                delivery.getSentDate(),
                delivery.getETA(),
                delivery.getWeight(),
                delivery.getPrice());

        deliveryService.saveDelivery(tmp);
        return deliveryService.convertToDTO(tmp);
    }

    @PostMapping(path="/update")
    public String update(@RequestBody Delivery delivery) {
        deliveryService.updateDelivery(delivery);
        return "Successfully updated delivery with name: " + delivery.getName();
    }

    @DeleteMapping(path="/delete")
    public String delete(@RequestParam Long id) {
        Delivery delivery = deliveryService.getDelivery(id);
        if(delivery != null) {
            deliveryService.deleteDelivery(delivery.getId());
            return "Delivery " + delivery.getName() + " successfully deleted!";
        }
        else {
            return "Delivery does not exist!";
        }
    }

    @GetMapping(path="/all")
    public List<DeliveryDTO> getAllDeliveries() {
        List<Delivery> deliveries = deliveryService.getDeliveries();
        List<DeliveryDTO> deliveryDTOS = new ArrayList<>();

        for(Delivery d : deliveries) {
            DeliveryDTO deliveryDTO = deliveryService.convertToDTO(d);
            deliveryDTOS.add(deliveryDTO);
        }
        return deliveryDTOS;
    }

    @GetMapping(path="/delivery")
    public DeliveryDTO getDelivery(@RequestParam Long id) {
        Delivery delivery = deliveryService.getDelivery(id);
        if(delivery == null) {
            return new DeliveryDTO();
        }
        else {
            return deliveryService.convertToDTO(delivery);
        }
    }

    @GetMapping(path = "/all/user")
    public List<DeliveryDTO> getAllDeliveriesFromUser(@RequestParam String username) {
        List<Delivery> deliveries = deliveryService.takeAllDeliveriesForCustomer(username);
        List<DeliveryDTO> deliveriesDTOS = new ArrayList<>();

        for(Delivery d : deliveries) {
            DeliveryDTO deliveryDTO = deliveryService.convertToDTO(d);
            deliveriesDTOS.add(deliveryDTO);
        }
        return deliveriesDTOS;
    }

}
