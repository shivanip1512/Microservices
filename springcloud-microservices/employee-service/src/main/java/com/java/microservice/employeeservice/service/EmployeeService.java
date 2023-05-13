package com.java.microservice.employeeservice.service;

import com.java.microservice.employeeservice.dto.ApiResponseDTO;
import com.java.microservice.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    ApiResponseDTO getEmployeeById(Long id);
}
