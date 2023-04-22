package com.java.microservice.departmentservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentDTO {
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
