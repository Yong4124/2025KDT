package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.dao.TodoDao;
import com.example.todo.model.Todo;

@Service
public class TodoService {

    private final TodoDao todoDao;

    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public List<Todo> findByUser(String username) {
        return todoDao.findTodosByUsername(username);
    }

    public void addTodo(Todo todo) {
        todoDao.insert(todo);
    }

    public void toggleCompleted(Long id, String username) {
        Todo todo = todoDao.findById(id);
        if (todo != null && todo.getUsername().equals(username)) {
            todo.setCompleted(!todo.isCompleted());
            todoDao.update(todo);
        }
    }

    public void deleteTodo(Long id, String username) {
        Todo todo = todoDao.findById(id);
        if (todo != null && todo.getUsername().equals(username)) {
            todoDao.delete(id);
        }
    }
}
