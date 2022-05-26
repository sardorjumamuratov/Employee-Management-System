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
    @Transactional
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

    @Override
    @Transactional
    public Employee findEmployeeById(Long id) {
        if(id != null) {
            return employeeRepository.findEmployeeById(id);
        }
        return new Employee();
    }

    @Override
    @Transactional
    public Employee updateById(Long id, Employee updatedEmployee) {
        Employee employee = employeeRepository.findEmployeeById(id);
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setUsername(updatedEmployee.getUsername());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setPassword(updatedEmployee.getPassword());
        employee.setAddress(updatedEmployee.getAddress());

        return this.saveEmployee(employee);
    }

}
