package com.sendi.todoversion1.controller;

import com.sendi.todoversion1.domain.Employee;
import com.sendi.todoversion1.service.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = {"/employees", "/", ""})
    public String getEmployees(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employees", employeeList);
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

    @GetMapping("/delete/{employeeId}")
    public String delete(@PathVariable("employeeId") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    @GetMapping("/update/{employeeId}")
    public String update(@PathVariable("employeeId") Long id, Model model) {
        Employee employeeBeingUpdated = employeeService.findEmployeeById(id);
        model.addAttribute("employee", employeeBeingUpdated);
        return "updateEmployee";
    }

    @PostMapping("/update")
    public String updateAndRedirect(@Valid Employee employee, @RequestParam("employeeId") Long id, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("employee", employeeService.findEmployeeById(id));
            return "updateEmployee";
        }

        employeeService.updateById(id, employee);
        return "redirect:/employees";
    }
}
