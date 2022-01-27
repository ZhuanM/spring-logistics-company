package com.LogisticsCompany.service;

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

    public OfficeServiceImpl(OfficeRepo officeRepo) {
        this.officeRepo = officeRepo;
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
}
