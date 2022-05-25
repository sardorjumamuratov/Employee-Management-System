package com.sendi.todoversion1.controller;

import com.sendi.todoversion1.domain.Employee;
import com.sendi.todoversion1.service.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = {"/employees", "/", ""})
    public String getUsers(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employees";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("employee", new Employee());
        return "login";
    }

    @PostMapping("/login")
    public String register(@Valid Employee employee, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors() || employee == null) {
            model.addAttribute("employee", employee);
            return "login";
        }

        Employee savedEmployee = employeeService.saveEmployee(employee);

        return "redirect:/employees";
    }
}
