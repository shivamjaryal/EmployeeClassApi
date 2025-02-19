package com.example.demoo.repository;

import com.example.demoo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    boolean existsByName(String employee);


}
