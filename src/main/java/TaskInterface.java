import java.util.List;

public interface TaskInterface {
    List<Task> getAllTasks();

    String addTask(String title);

    boolean deleteTask(int id);

    boolean completeTask(int id);

}
