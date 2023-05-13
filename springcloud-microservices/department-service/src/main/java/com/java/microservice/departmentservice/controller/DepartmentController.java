package com.java.microservice.departmentservice.controller;

import com.java.microservice.departmentservice.dto.DepartmentDTO;
import com.java.microservice.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<DepartmentDTO> saveDept(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO savedDepartment = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{dept-code}")
    public ResponseEntity<DepartmentDTO> getDepartmentByDepartmentCode(@PathVariable("dept-code") String departmentCode){
        DepartmentDTO departmentByCode = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentByCode,HttpStatus.OK);
    }
}
