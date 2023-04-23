package com.java.microservice.employeeservice.service.impl;

import com.java.microservice.employeeservice.dto.ApiResponseDTO;
import com.java.microservice.employeeservice.dto.DepartmentDTO;
import com.java.microservice.employeeservice.dto.EmployeeDTO;
import com.java.microservice.employeeservice.entity.Employee;
import com.java.microservice.employeeservice.exception.ResourceNotFoundException;
import com.java.microservice.employeeservice.mapper.AutoEmployeeMapper;
import com.java.microservice.employeeservice.repository.EmployeeRepository;
import com.java.microservice.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository empRepository;
//    private RestTemplate restTemplate;
    private WebClient webClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = AutoEmployeeMapper.AUTO_EMPLOYEE_MAPPER.mapToEmployee(employeeDTO);
        Employee savedEmployee = empRepository.save(employee);
        return AutoEmployeeMapper.AUTO_EMPLOYEE_MAPPER.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public ApiResponseDTO getEmployeeById(Long id) {
        Employee employeeById = empRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));

//        ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employeeById.getDepartmentCode(), DepartmentDTO.class);
//        DepartmentDTO departmentDTO = responseEntity.getBody();
        DepartmentDTO departmentDTO = webClient.get().uri("http://localhost:8080/api/departments/" + employeeById.getDepartmentCode()).retrieve().bodyToMono(DepartmentDTO.class).block();
        EmployeeDTO employeeDTO = AutoEmployeeMapper.AUTO_EMPLOYEE_MAPPER.mapToEmployeeDTO(employeeById);
        return new ApiResponseDTO(employeeDTO, departmentDTO);
    }
}
