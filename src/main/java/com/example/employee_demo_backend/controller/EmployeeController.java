package com.example.employee_demo_backend.controller;

import com.example.employee_demo_backend.entity.Employee;
import com.example.employee_demo_backend.services.Interface.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> data = employeeService.getAllEmployees();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee data = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Validated @RequestBody Employee employee) {
        Employee data = employeeService.createEmployee(employee);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,
                                                   @Validated @RequestBody Employee employee) {
        Employee data = employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return HttpStatus.OK;
    }
}
