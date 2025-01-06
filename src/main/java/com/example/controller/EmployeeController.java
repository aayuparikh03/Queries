package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/salary/{salary}/department/{departmentId}")
    public List<Employee> getEmployeeBySalaryAndDepartment(
            @PathVariable Double salary,
            @PathVariable Long departmentId)
    {
        return employeeService.getEmployeeBySalaryAndDepartment(salary, departmentId);
    }

}
