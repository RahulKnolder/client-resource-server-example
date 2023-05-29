package com.knoldus.resourcesercer.services.servicesimpl;
import com.knoldus.resourcesercer.model.Employee;
import com.knoldus.resourcesercer.repository.EmployeRepository;
import com.knoldus.resourcesercer.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeRepository employeRepository;
    @Override
    public List<Employee> getEmployeeAll() {
        return employeRepository.findAll();
    }

    @Override
    public Employee addEmployees(Employee employee) {
        return employeRepository.save(employee);
    }


}
