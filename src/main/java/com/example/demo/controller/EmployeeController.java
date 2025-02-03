package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    // POS
    @Autowired
    private EmployeeService employeeService1;

    // POST = Add/Create
    @PostMapping("/save")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        if (employeeService1.saveemployeeModel(employee)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(employee);

        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(employee);
        }


    }

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> employees = employeeService1.findAllemployee(employeeService1);

        if (!employees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(employees);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService1.updateEmployee(employee);
        if (updatedEmployee != null) {

            return ResponseEntity.ok((Employee) updatedEmployee);
        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
        boolean isDeleted = employeeService1.deleteEmployee(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


        }
    }
}