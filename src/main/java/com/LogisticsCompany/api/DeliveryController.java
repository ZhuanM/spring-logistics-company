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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @PostMapping(path="/save")
    public DeliveryDTO saveDelivery(@RequestBody DeliveryDTO deliveryDTO) {
        return deliveryService.createDelivery(deliveryDTO);
    }

    @PostMapping(path="/update")
    public void update(@RequestBody DeliveryDTO deliveryDTO) {
        deliveryService.updateDelivery(deliveryDTO);
    }

    @DeleteMapping(path="/delete")
    public void delete(@RequestParam Long id) {
        Delivery delivery = deliveryService.getDelivery(id);
        if(delivery != null) {
            deliveryService.deleteDelivery(delivery.getId());
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
//        List<DeliveryDTO> deliveriesDTOS = new ArrayList<>();
//
//        for(Delivery d : deliveries) {
//            DeliveryDTO deliveryDTO = deliveryService.convertToDTO(d);
//            deliveriesDTOS.add(deliveryDTO);
//        }
//        return deliveriesDTOS;
        return deliveryService.listEntitiesToDTO(deliveries);
    }

}
