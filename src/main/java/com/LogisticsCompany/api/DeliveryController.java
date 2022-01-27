package com.LogisticsCompany.api;

import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.Company;
import com.LogisticsCompany.entity.Delivery;
import com.LogisticsCompany.service.CompanyService;
import com.LogisticsCompany.service.DeliveryService;
import com.LogisticsCompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
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

//    @GetMapping(path="/")
//    public String greet() {
//        return "Page for deliveries of NBU Logistics Company";
//    }

    @PostMapping(path="/save-delivery")
    public Delivery saveDelivery(@RequestBody Delivery delivery) {
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

        return deliveryService.saveDelivery(tmp);
    }

    @PutMapping(path="/update-delivery")
    public String update(@RequestBody Delivery delivery) {
        deliveryService.updateDelivery(delivery);
        return "Successfully updated delivery with name: " + delivery.getName();
    }

    @DeleteMapping(path="/delete-delivery")
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

    @GetMapping(path="/deliveries/all")
    public List<String> getAllDeliveries() {
        return deliveryService.getDeliveries();
    }

    @GetMapping(path="/delivery")
    public Delivery getDelivery(@RequestParam long id) {
        Delivery delivery = deliveryService.getDelivery(Long.valueOf(id));
        if(delivery == null) {
            return new Delivery();
        }
        else {
            return delivery;
        }
    }

}
