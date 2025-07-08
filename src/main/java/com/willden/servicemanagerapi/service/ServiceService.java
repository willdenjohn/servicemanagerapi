package com.willden.servicemanagerapi.service;

import com.willden.servicemanagerapi.dto.ServiceDTO;
import java.util.List;

public interface ServiceService {
    ServiceDTO create(ServiceDTO dto);
    ServiceDTO update(Long id, ServiceDTO dto);
    void delete(Long id);
    ServiceDTO findById(Long id);
    List<ServiceDTO> findAll();
}