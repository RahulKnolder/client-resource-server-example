package com.knoldus.resourcesercer.services.servicesimpl;
import com.knoldus.resourcesercer.model.Employee;
import com.knoldus.resourcesercer.repository.EmployeRepository;
import com.knoldus.resourcesercer.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

   static List<Employee> employees=new ArrayList<>();

    static {

        employees.add(new Employee(1L,"Rhaul","knoldus"));

    }
    @Autowired
    EmployeRepository employeRepository;
    @Override
    public List<Employee> getEmployeeAll() {
        return employees;
//        return employeRepository.findAll();
    }

    @Override
    public Employee addEmployees(Employee employee) {
        return employeRepository.save(employee);
    }


}
