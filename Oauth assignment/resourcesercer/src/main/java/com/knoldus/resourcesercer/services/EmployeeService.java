package com.knoldus.resourcesercer.services;


import com.knoldus.resourcesercer.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    public List<Employee> getEmployeeAll();

    public Employee addEmployees(Employee employee);

}
