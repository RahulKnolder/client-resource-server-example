package com.knoldus.resourcesercer.repository;

import com.knoldus.resourcesercer.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employee,Long> {
}
