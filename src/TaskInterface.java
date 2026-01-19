import java.util.List;

public interface TaskInterface {
    List<Task> getAllTasks();

    void addTask(String title);

    boolean deleteTask(int id);

    void completeTask(int id);

}
