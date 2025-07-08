package com.willden.servicemanagerapi.controller;

import com.willden.servicemanagerapi.dto.ServiceDTO;
import com.willden.servicemanagerapi.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService serviceService;
    @PostMapping
    public ResponseEntity<ServiceDTO> create(@Validated @RequestBody ServiceDTO dto) {
        ServiceDTO created = serviceService.create(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceDTO> update(@PathVariable Long id, @Validated @RequestBody ServiceDTO dto) {
        ServiceDTO updated = serviceService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        serviceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ServiceDTO>> findAll() {
        return ResponseEntity.ok(serviceService.findAll());
    }
}
