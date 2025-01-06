package com.example.repository;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "select * from employee e where e.salary > :salary " +
            "AND e.department_id= :departmentId", nativeQuery = true)
    List<Employee> findEmployeeByIdAndDepartment(
            @Param("salary")Double salary,
            @Param("departmentId") Long departmentId);

}
