package com.LogisticsCompany.service;

import com.LogisticsCompany.dto.OfficeDTO;
import com.LogisticsCompany.entity.Office;

import java.util.List;

public interface OfficeService {
    Office saveOffice(Office office);
    OfficeDTO createOffice(Office office);
    void updateOffice(Office office);
    void deleteOffice(Long id);
    Office getOffice(String address);
    Office getOfficeById(Long id);
    List<Office> getOffices();
    OfficeDTO convertToDTO(Office office);
    Office convertToEntity(OfficeDTO office);
    List<OfficeDTO> listEntitiesToDTO(List<Office> offices);
}
