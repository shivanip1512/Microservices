package com.java.microservice.employeeservice.service;

import com.java.microservice.employeeservice.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{dept-code}")
    DepartmentDTO getDepartmentByDepartmentCode(@PathVariable("dept-code") String departmentCode);
}
