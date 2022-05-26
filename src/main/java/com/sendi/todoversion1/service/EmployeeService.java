package com.sendi.todoversion1.service;


import com.sendi.todoversion1.domain.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee saveEmployee(Employee employee);

    void deleteEmployeeById(Long id);

    Employee findEmployeeById(Long id);

    Employee updateById(Long id, Employee employee);
}
