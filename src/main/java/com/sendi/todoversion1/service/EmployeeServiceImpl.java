package com.sendi.todoversion1.service;

import com.sendi.todoversion1.domain.Employee;
import com.sendi.todoversion1.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository userRepository;

    public EmployeeServiceImpl(EmployeeRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Employee> findAll() {
        return userRepository.findAll();
    }
}
