package com.example.demoo.service;

import com.example.demoo.Exception.EmployeeAlreadyExistsException;
import com.example.demoo.model.Employee;
import com.example.demoo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;


    public boolean saveemployeeModel(Employee employee) {
        if (repository.existsByName(String.valueOf(employee.getName()))) {
            throw new EmployeeAlreadyExistsException("Employee with name " + employee.getName() + " " + "Already Exists " + "Status Code = " + HttpStatus.CONFLICT);

        } else {
            repository.save(employee);
            return true;
        }
    }

    public List<Employee> findAllemployee(EmployeeService employeeService1) {
        return repository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        if (repository.existsById(employee.getId())) {
            return repository.save(employee);
        }
        return null;


    }

    public boolean deleteEmployee(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    }
