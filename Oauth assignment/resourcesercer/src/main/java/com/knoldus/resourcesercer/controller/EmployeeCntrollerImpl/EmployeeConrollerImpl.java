package com.knoldus.resourcesercer.controller.EmployeeCntrollerImpl;

import com.knoldus.resourcesercer.controller.EmployeeController;
import com.knoldus.resourcesercer.model.Employee;
import com.knoldus.resourcesercer.services.servicesimpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class EmployeeConrollerImpl implements EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @Override
    public ResponseEntity<Employee> addEmployee(Employee employee) {
        return ResponseEntity.ok( employeeService.addEmployees(employee));
    }

    @Override
    public ResponseEntity<List<Employee>> getAllEmployee() {
      return ResponseEntity.ok(employeeService.getEmployeeAll());
    }



}
