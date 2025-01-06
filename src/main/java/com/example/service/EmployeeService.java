package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAllEmployees();
    }

    public List<Employee> getEmployeesWithHighSalary(Double salary) {
        return employeeRepository.findEmployeesWithSalaryGreaterThan(salary);
    }

    public List<Employee> getEmployeesByDepartment(String departmentName) {
        return employeeRepository.findEmployeesByDepartmentName(departmentName);
    }

    public List<Employee> getAllEmployeesOrderedBySalary() {
        return employeeRepository.findAllEmployeesOrderedBySalary();
    }
}
