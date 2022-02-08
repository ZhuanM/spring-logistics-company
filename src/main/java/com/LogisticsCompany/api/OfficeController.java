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

@CrossOrigin(origins = "http://localhost:4202")
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

    @PostMapping(path="/save")
    public OfficeDTO saveOffice(@RequestBody Office office) {
//        Company company = companyService.getCompany(office.getCompany().getId());
//
//        Office tmp = new Office(null,
//                office.getName(),
//                office.getAddress(),
//                company);
//
//        officeService.saveOffice(tmp);
//        return officeService.convertToDTO(tmp);
        return officeService.createOffice(office);
    }

    @PostMapping(path="/update")
    public void update(@RequestBody Office office) {
        officeService.updateOffice(office);
    }

    @DeleteMapping(path="/delete")
    public void delete(@RequestParam Long id) {
        Office office = officeService.getOfficeById(id);
        if(office != null) {
            officeService.deleteOffice(office.getId());
        }
    }

    @GetMapping(path="/all")
    public List<OfficeDTO> getAllOffices() {
        List<Office> offices = officeService.getOffices();
        return officeService.listEntitiesToDTO(offices);
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
