package com.java.microservice.departmentservice.service.impl;

import com.java.microservice.departmentservice.dto.DepartmentDTO;
import com.java.microservice.departmentservice.entity.Department;
import com.java.microservice.departmentservice.exception.ResourceNotFoundException;
import com.java.microservice.departmentservice.mapper.AutoDepartmentMapper;
import com.java.microservice.departmentservice.repository.DepartmentRepository;
import com.java.microservice.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        //convert departmentDTO to department entity
        Department department = AutoDepartmentMapper.AUTO_DEPARTMENT_MAPPER.mapToDepartment(departmentDTO);

        Department savedDept = departmentRepository.save(department);

        //convert department entity to department DTO
        return AutoDepartmentMapper.AUTO_DEPARTMENT_MAPPER.mapToDepartmentDTO(savedDept);
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String code) {
        Department departmentByDepartmentCode = departmentRepository.findByDepartmentCode(code);
        if(departmentByDepartmentCode==null){
            throw new ResourceNotFoundException("Department","Department Code",code);
        }
        return AutoDepartmentMapper.AUTO_DEPARTMENT_MAPPER.mapToDepartmentDTO(departmentByDepartmentCode);
    }


}
