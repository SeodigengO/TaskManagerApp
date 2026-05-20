package DAO;

import com.thatie.TaskManagerApp.Domain.Task;

import java.util.Optional;

public interface TaskDao {
    void addTask(Task task);

    Optional<Task> getTaskById(Long id);
}
