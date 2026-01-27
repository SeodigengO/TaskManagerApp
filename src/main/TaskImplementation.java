package main;

import java.util.ArrayList;
import java.util.List;

public class TaskImplementation implements TaskInterface {

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
    public boolean deleteTask(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }


    @Override
    public boolean completeTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markCompleted();
                return true;
            }
        }
        return false;
    }

}
