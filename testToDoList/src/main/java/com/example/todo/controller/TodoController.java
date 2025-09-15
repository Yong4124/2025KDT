package com.example.todo.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;

@Controller
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/list")
    public String list(Model model, Authentication authentication) {
        String username = authentication != null ? authentication.getName() : null;
        List<Todo> todos = todoService.findByUser(username);
        model.addAttribute("todos", todos);
        model.addAttribute("username", username);
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String title, Authentication authentication) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setCompleted(false);
        todo.setUsername(authentication.getName());

        todoService.addTodo(todo);
        return "redirect:/list";
    }

    // 할 일 완료 토글
    @GetMapping("/toggle/{id}")
    public String toggle(@PathVariable Long id, Authentication authentication) {
        todoService.toggleCompleted(id, authentication.getName());
        return "redirect:/list";
    }

    // 할 일 삭제
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Authentication authentication) {
        todoService.deleteTodo(id, authentication.getName());
        return "redirect:/list";
    }
}
