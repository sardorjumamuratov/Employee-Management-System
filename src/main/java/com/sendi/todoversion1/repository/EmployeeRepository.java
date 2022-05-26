package com.sendi.todoversion1.repository;

import com.sendi.todoversion1.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsEmployeeByEmail(String email);

    void deleteEmployeeById(Long id);
}
