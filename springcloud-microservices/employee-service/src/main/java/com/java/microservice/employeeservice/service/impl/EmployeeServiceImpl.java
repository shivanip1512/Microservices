package com.java.microservice.employeeservice.service.impl;

import com.java.microservice.employeeservice.dto.EmployeeDTO;
import com.java.microservice.employeeservice.entity.Employee;
import com.java.microservice.employeeservice.exception.ResourceNotFoundException;
import com.java.microservice.employeeservice.mapper.AutoEmployeeMapper;
import com.java.microservice.employeeservice.repository.EmployeeRepository;
import com.java.microservice.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository empRepository;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = AutoEmployeeMapper.AUTO_EMPLOYEE_MAPPER.mapToEmployee(employeeDTO);
        Employee savedEmployee = empRepository.save(employee);
        return AutoEmployeeMapper.AUTO_EMPLOYEE_MAPPER.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employeeById = empRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));
        return AutoEmployeeMapper.AUTO_EMPLOYEE_MAPPER.mapToEmployeeDTO(employeeById);
    }
}
