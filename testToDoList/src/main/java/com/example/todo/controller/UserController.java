package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todo.dao.UserDao;
import com.example.todo.model.User;

@Controller
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login"; // login.jsp
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register"; // register.jsp
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           Model model) {
        if (userDao.findByUsername(username) != null) {
            model.addAttribute("error", "이미 존재하는 사용자 이름입니다.");
            return "register";
        }

        userDao.addUser(new User(username, password));
        return "redirect:/login";
    }
}
