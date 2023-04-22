package com.java.microservice.employeeservice.mapper;

import com.java.microservice.employeeservice.dto.EmployeeDTO;
import com.java.microservice.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEmployeeMapper {

    AutoEmployeeMapper AUTO_EMPLOYEE_MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    Employee mapToEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO mapToEmployeeDTO(Employee employee);
}
