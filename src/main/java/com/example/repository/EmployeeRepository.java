package com.example.repository;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // Basic SELECT Query
    @Query("SELECT e FROM Employee e")
    List<Employee> findAllEmployees();

    // Query with WHERE Clause
    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    List<Employee> findEmployeesWithSalaryGreaterThan(@Param("salary") Double salary);

    // JOIN Query
    @Query("SELECT e FROM Employee e JOIN e.department d " +
            "WHERE d.name = :departmentName")
    List<Employee> findEmployeesByDepartmentName(
            @Param("departmentName") String departmentName);

    // ORDER BY Query
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> findAllEmployeesOrderedBySalary();

}
