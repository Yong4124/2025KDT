package com.example.todo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        // 홈 화면에 필요한 로직 작성 가능
        // 예: 로그인한 사용자 정보 가져오기 등

        return "home";  // home.jsp 또는 home.html 뷰 이름
    }
}
