package com.LogisticsCompany.service;

import com.LogisticsCompany.dto.OfficeDTO;
import com.LogisticsCompany.entity.Office;
import com.LogisticsCompany.repo.OfficeRepo;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OfficeServiceImpl implements OfficeService{

    @Autowired
    private final OfficeRepo officeRepo;
    @Autowired
    private final CompanyService companyService;

    public OfficeServiceImpl(OfficeRepo officeRepo, CompanyService companyService) {
        this.officeRepo = officeRepo;
        this.companyService = companyService;
    }

    @Override
    public Office saveOffice(Office office) throws ConstraintViolationException {
        return officeRepo.save(office);
    }

    @Override
    public void updateOffice(Office office) {
        Office tmp;
        tmp = officeRepo.findByAddress(office.getAddress());
        tmp.setName(office.getName());
        officeRepo.save(tmp);
    }

    @Override
    public void deleteOffice(Long id) {
        officeRepo.deleteById(id);
    }

    @Override
    public Office getOffice(String address) {
        return officeRepo.findByAddress(address);
    }


    @Override
    public Office getOfficeById(Long id) {
        return officeRepo.getById(id);
    }

    @Override
    public List<Office> getOffices() {
        return officeRepo.findAll();
    }



    @Override
    public OfficeDTO convertToDTO(Office office) {
        OfficeDTO officeDTO = new OfficeDTO();
        if(office != null) {
            officeDTO.setId(office.getId());
            officeDTO.setName(office.getName());
            officeDTO.setAddress(office.getAddress());
            officeDTO.setCompany(companyService.convertToDTO(office.getCompany()));
        }
        return officeDTO;
    }

    @Override
    public Office convertToEntity(OfficeDTO officeDTO) {
        Office office = new Office();
        if(officeDTO != null) {
            office.setId(officeDTO.getId());
            office.setName(officeDTO.getName());
            office.setAddress(officeDTO.getAddress());
            office.setCompany(companyService.convertToEntity(officeDTO.getCompany()));
        }
        return office;
    }
}
