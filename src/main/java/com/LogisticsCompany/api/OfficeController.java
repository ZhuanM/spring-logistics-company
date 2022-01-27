package com.LogisticsCompany.api;

import com.LogisticsCompany.entity.Company;
import com.LogisticsCompany.entity.Office;
import com.LogisticsCompany.service.CompanyService;
import com.LogisticsCompany.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class OfficeController {

    @Autowired
    private final OfficeService officeService;

    @Autowired
    private final CompanyService companyService;

    public OfficeController(OfficeService officeService, CompanyService companyService) {
        this.officeService = officeService;
        this.companyService = companyService;
    }

    @PostMapping(path="/save-office")
    public Office saveOffice(@RequestBody Office office) {
        Company company = companyService.getCompany(office.getCompany().getId());

        Office tmp = new Office(null,
                office.getName(),
                office.getAddress(),
                company);

        return officeService.saveOffice(tmp);
    }

    @PutMapping(path="/update-office")
    public String update(@RequestBody Office office) {
        officeService.updateOffice(office);
        return "Successfully updated office with name: " + office.getName();
    }

    @DeleteMapping(path="/delete-office")
    public String delete(@RequestParam Long id) {
        Office office = officeService.getOfficeById(id);
        if(office != null) {
            officeService.deleteOffice(office.getId());
            return "Office " + office.getName() + " successfully deleted!";
        }
        else {
            return "Delivery does not exist!";
        }
    }

    @GetMapping(path="/offices/all")
    public List<Office> getAllOffices() {
        return officeService.getOffices();
    }

    @GetMapping(path="/office")
    public Office getDelivery(@RequestParam long id) {
        Office delivery = officeService.getOfficeById(Long.valueOf(id));
        if(delivery == null) {
            return new Office();
        }
        else {
            return delivery;
        }
    }
}
