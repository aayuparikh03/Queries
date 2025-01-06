package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeesBySalary(Double salary) {
        return employeeRepository.findEmployeesBySalaryGreaterThan(salary);
    }

    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findEmployeesByName(name);
    }
}
