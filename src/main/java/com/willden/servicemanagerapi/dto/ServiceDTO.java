package com.willden.servicemanagerapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceDTO {
    private Long id;
    private String name;
    private String description;
    private String category;
}