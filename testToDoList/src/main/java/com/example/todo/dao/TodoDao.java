package com.example.todo.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.todo.model.Todo;

@Repository
public class TodoDao {

    private final JdbcTemplate jdbcTemplate;

    public TodoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Todo> findTodosByUsername(String username) {
        String sql = "SELECT id, title, completed, username FROM todos WHERE username = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Todo todo = new Todo();
            todo.setId(rs.getLong("id"));
            todo.setTitle(rs.getString("title"));
            todo.setCompleted(rs.getBoolean("completed"));
            todo.setUsername(rs.getString("username"));
            return todo;
        }, username);
    }

    public void insert(Todo todo) {
        String sql = "INSERT INTO todos (title, completed, username) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, todo.getTitle(), todo.isCompleted(), todo.getUsername());
    }

    public Todo findById(Long id) {
        String sql = "SELECT id, title, completed, username FROM todos WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Todo todo = new Todo();
            todo.setId(rs.getLong("id"));
            todo.setTitle(rs.getString("title"));
            todo.setCompleted(rs.getBoolean("completed"));
            todo.setUsername(rs.getString("username"));
            return todo;
        }, id);
    }

    public void update(Todo todo) {
        String sql = "UPDATE todos SET title = ?, completed = ? WHERE id = ?";
        jdbcTemplate.update(sql, todo.getTitle(), todo.isCompleted(), todo.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM todos WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
