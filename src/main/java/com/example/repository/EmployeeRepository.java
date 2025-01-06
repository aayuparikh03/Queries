package com.example.repository;

import com.example.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> findEmployeesBySalaryGreaterThan(Double salary) {
        // Step 1: Create CriteriaBuilder
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        // Step 2: Create CriteriaQuery
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);

        // Step 3: Define Root
        Root<Employee> root = query.from(Employee.class);

        // Step 4: Define Predicate
        Predicate salaryPredicate = cb.greaterThan(root.get("salary"), salary);

        // Step 5: Add Predicate to CriteriaQuery
        query.select(root).where(salaryPredicate);

        // Step 6: Execute Query
        return entityManager.createQuery(query).getResultList();
    }

    public List<Employee> findEmployeesByName(String name) {
        // Step 1: Create CriteriaBuilder
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        // Step 2: Create CriteriaQuery
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);

        // Step 3: Define Root
        Root<Employee> root = query.from(Employee.class);

        // Step 4: Define Predicate
        Predicate namePredicate = cb.equal(root.get("name"), name);

        // Step 5: Add Predicate to CriteriaQuery
        query.select(root).where(namePredicate);

        // Step 6: Execute Query
        return entityManager.createQuery(query).getResultList();
    }
}
