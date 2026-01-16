import java.util.ArrayList;
import java.util.List;

public class TaskService implements TaskInterface {

    private List<Task> tasks = new ArrayList<>();
    private int taskId = 1;

    @Override
    public List<Task> getAllTasks(){
        return tasks;
    }

    @Override
    public void addTask(String title){
        Task task = new Task(taskId,title);
        tasks.add(task);
        taskId++;
    }

    @Override
    public void deleteTask(int id){
        tasks.remove(id);
    }


}
