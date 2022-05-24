package com.sendi.todoversion1.controller;

import com.sendi.todoversion1.domain.User;
import com.sendi.todoversion1.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsers(){
        return "users";
    }

    @GetMapping("/getusers")
    public String getUsers(Model model) {
        User user = new User();

        model.addAttribute("users", userService.findAll());

        return "users";
    }

}
