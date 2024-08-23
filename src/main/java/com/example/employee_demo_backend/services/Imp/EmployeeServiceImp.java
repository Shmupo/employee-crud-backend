package com.example.employee_demo_backend.services.Imp;

import com.example.employee_demo_backend.entity.Employee;
import com.example.employee_demo_backend.exception.ResourceNotFoundException;
import com.example.employee_demo_backend.repository.EmployeeRepository;
import com.example.employee_demo_backend.services.Interface.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee foundEmployee = employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        foundEmployee.setFirstName(employee.getFirstName());
        foundEmployee.setLastName(employee.getLastName());
        foundEmployee.setEmail(employee.getEmail());
        foundEmployee.setSalary(employee.getSalary());

        return employeeRepository.save(foundEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee foundEmployee = employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        employeeRepository.delete(foundEmployee);
    }
}
