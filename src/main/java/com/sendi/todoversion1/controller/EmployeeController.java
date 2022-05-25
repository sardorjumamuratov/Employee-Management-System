package com.sendi.todoversion1.controller;

import com.sendi.todoversion1.domain.Employee;
import com.sendi.todoversion1.service.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String showUsers(){
        return "users";
    }

    @GetMapping("/getusers")
    public String getUsers(Model model) {
        Employee user = new Employee();

        model.addAttribute("users", employeeService.findAll());

        return "users";
    }

    @GetMapping("/form")
    public String getForm () {
        return "form";
    }

}
