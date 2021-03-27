package com.example.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }
}
