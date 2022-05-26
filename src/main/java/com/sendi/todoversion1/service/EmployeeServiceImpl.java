package com.sendi.todoversion1.service;

import com.sendi.todoversion1.domain.Employee;
import com.sendi.todoversion1.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        if(!employeeRepository.existsEmployeeByEmail(employee.getEmail())) {
            return employeeRepository.save(employee);
        }

        return null;
    }

    @Override
    @Transactional
    public void deleteEmployeeById(Long id) {
        if (id != null) {
            employeeRepository.deleteEmployeeById(id);
        }
    }
}
