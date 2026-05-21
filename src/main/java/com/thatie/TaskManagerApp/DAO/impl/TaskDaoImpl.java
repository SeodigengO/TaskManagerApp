package com.thatie.TaskManagerApp.DAO.impl;

import DAO.TaskDao;
import com.thatie.TaskManagerApp.Domain.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class TaskDaoImpl implements TaskDao {

    private final JdbcTemplate jdbcTemplate;

    public TaskDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void addTask(Task task) {
        jdbcTemplate.update(
                "INSERT INTO tasks (id, title, status, created_at) VALUES (?,?,?,?)",
                task.getId(),
                task.getTitle(),
                task.getStatus(),
                task.getCreatedAt()
        );
    }

//
    @Override
    public List<Task> getAllTasks(){
        return  jdbcTemplate.query("SELECT id, title, status, created_at FROM tasks",
                new TaskRowMapper());
    }


    @Override
    public Optional<Task> getTaskById(Long id) {
        List<Task> results = jdbcTemplate.query(
                "SELECT id, title, status, created_at FROM tasks WHERE id = ? LIMIT 1",
                new TaskRowMapper(),
                id
        );

        return results.stream().findFirst();
    }

    public static class TaskRowMapper implements RowMapper<Task> {
        @Override
        public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Task.builder()
                    .id(rs.getLong("id"))
                    .title(rs.getString("title"))
                    .status(rs.getString("status"))
                    .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                    .build();
        }

    }

    @Override
    public void deleteTask(Long id){
        jdbcTemplate.update("DELETE FROM tasks where id = ?", id);
    }

    @Override
    public void updateTask(Long id, Task task){
        jdbcTemplate.update("UPDATE tasks SET title = ?, status = ?, created_at = ? WHERE id = ?",task.getTitle(),task.getStatus(),task.getCreatedAt(), id );
    }

}
