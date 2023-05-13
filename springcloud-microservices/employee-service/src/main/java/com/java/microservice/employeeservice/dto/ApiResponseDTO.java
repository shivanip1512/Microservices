package com.java.microservice.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponseDTO {
    private EmployeeDTO employeeDTO;
    private DepartmentDTO departmentDTO;
}
