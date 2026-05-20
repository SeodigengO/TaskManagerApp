package DAO;

import com.thatie.TaskManagerApp.Domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskDao {
    void addTask(Task task);

    Optional<Task> getTaskById(Long id);

    List<Task> getAllTasks();

    void deleteTask(Long id);

    void updateTask(Long id, Task task);
}
