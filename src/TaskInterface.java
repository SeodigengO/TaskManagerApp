import java.util.List;

public interface TaskInterface {
    List<Task> getAllTasks();

    void addTask(String title);

    void deleteTask(int id);

//    void completeTask(int id);

}
