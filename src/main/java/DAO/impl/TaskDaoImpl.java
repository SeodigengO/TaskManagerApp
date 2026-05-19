package DAO.impl;

import DAO.TaskDao;
import com.thatie.TaskManagerApp.Domain.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TaskDaoImpl implements TaskDao {

    private final JdbcTemplate jdbcTemplate;

    public TaskDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addTask(Task task){
        jdbcTemplate.update("INSERT INTO tasks (id,title,status,createdAt) VALUES (?,?,?,?)",
                task.getId(),
                task.getTitle(),
                task.getStatus(),
                task.getCreatedAt(
                ));
    }

}
