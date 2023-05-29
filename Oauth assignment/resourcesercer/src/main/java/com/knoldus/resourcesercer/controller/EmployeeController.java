package com.knoldus.resourcesercer.controller;

import com.knoldus.resourcesercer.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public interface EmployeeController {
    @PostMapping("/addemployees")
    public ResponseEntity<Employee> addEmployee(Employee employee);

    @GetMapping("/getemployees")
    public ResponseEntity<List<Employee>> getAllEmployee();



}
