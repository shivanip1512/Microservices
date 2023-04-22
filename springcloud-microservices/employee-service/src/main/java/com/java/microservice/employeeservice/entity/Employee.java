package com.java.microservice.employeeservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(nullable = false,unique = true)
    private String email;
}
