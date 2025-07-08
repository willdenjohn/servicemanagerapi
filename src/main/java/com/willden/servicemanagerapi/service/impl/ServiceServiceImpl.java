package com.willden.servicemanagerapi.service.impl;

import com.willden.servicemanagerapi.dto.ServiceDTO;
import com.willden.servicemanagerapi.entity.Service;
import com.willden.servicemanagerapi.repository.ServiceRepository;
import com.willden.servicemanagerapi.service.ServiceService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository repository;

    @Override
    public ServiceDTO create(ServiceDTO dto) {
        Service service = Service.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .build();
        service = repository.save(service);
        return toDTO(service);
    }

    @Override
    public ServiceDTO update(Long id, ServiceDTO dto) {
        Service service = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        service.setName(dto.getName());
        service.setDescription(dto.getDescription());
        service.setCategory(dto.getCategory());
        service = repository.save(service);
        return toDTO(service);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ServiceDTO findById(Long id) {
        Service service = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        return toDTO(service);
    }

    @Override
    public List<ServiceDTO> findAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ServiceDTO toDTO(Service service) {
        return ServiceDTO.builder()
                .id(service.getId())
                .name(service.getName())
                .description(service.getDescription())
                .category(service.getCategory())
                .build();
    }
}