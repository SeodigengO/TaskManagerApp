package com.thatie.TaskManagerApp.DaoImpl;


import com.thatie.TaskManagerApp.DAO.impl.TaskDaoImpl;
import com.thatie.TaskManagerApp.Domain.Task;
import com.thatie.TaskManagerApp.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TaskDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TaskDaoImpl underTest;

    @Test
    public void testCreateGenerateCorrectSql() {
        Task task = TestDataUtil.createTask();

        underTest.addTask(task);
        ArgumentCaptor<LocalDateTime> captor = ArgumentCaptor.forClass(LocalDateTime.class);

        verify(jdbcTemplate).update(
                eq("INSERT INTO tasks (id, title, status, created_at) VALUES (?,?,?,?)"),
                eq(task.getId()),
                eq(task.getTitle()),
                eq(task.getStatus()),
                captor.capture()
        );

        assertNotNull(captor.getValue());
    }
}