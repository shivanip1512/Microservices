package com.java.microservice.departmentservice.mapper;

import com.java.microservice.departmentservice.dto.DepartmentDTO;
import com.java.microservice.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {

    AutoDepartmentMapper AUTO_DEPARTMENT_MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    Department mapToDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO mapToDepartmentDTO(Department department);

}
