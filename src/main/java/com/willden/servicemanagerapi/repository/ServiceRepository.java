package com.willden.servicemanagerapi.repository;

import com.willden.servicemanagerapi.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}