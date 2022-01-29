package com.LogisticsCompany.api;

import com.LogisticsCompany.dto.OfficeDTO;
import com.LogisticsCompany.entity.Company;
import com.LogisticsCompany.entity.Office;
import com.LogisticsCompany.service.CompanyService;
import com.LogisticsCompany.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/offices")
public class OfficeController {

    @Autowired
    private final OfficeService officeService;

    @Autowired
    private final CompanyService companyService;

    public OfficeController(OfficeService officeService, CompanyService companyService) {
        this.officeService = officeService;
        this.companyService = companyService;
    }

    @GetMapping(path="")
    public String greet() {
        return "Page for offices of NBU Logistics Company";
    }

    @PostMapping(path="/save")
    public OfficeDTO saveOffice(@RequestBody Office office) {
        Company company = companyService.getCompany(office.getCompany().getId());

        Office tmp = new Office(null,
                office.getName(),
                office.getAddress(),
                company);

        officeService.saveOffice(tmp);
        return officeService.convertToDTO(tmp);
    }

    @PutMapping(path="/update")
    public String update(@RequestBody Office office) {
        officeService.updateOffice(office);
        return "Successfully updated office with name: " + office.getName();
    }

    @DeleteMapping(path="/delete")
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

    @GetMapping(path="/all")
    public List<OfficeDTO> getAllOffices() {
        List<Office> deliveries = officeService.getOffices();
        List<OfficeDTO> officeDTOS = new ArrayList<>();

        for(Office o : deliveries) {
            OfficeDTO officeDTO = officeService.convertToDTO(o);
            officeDTOS.add(officeDTO);
        }
        return officeDTOS;
    }

    @GetMapping(path="/office")
    public OfficeDTO getDelivery(@RequestParam Long id) {
        Office office = officeService.getOfficeById(id);
        if(office == null) {
            return new OfficeDTO();
        }
        else {
            return officeService.convertToDTO(office);
        }
    }
}
