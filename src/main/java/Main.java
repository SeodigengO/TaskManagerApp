
import java.util.List;
import java.util.Scanner;

public class Main{
   public static void main(String[] args){

       TaskInterface taskInterface = new TaskImplementation();

       Scanner scanner = new Scanner(System.in);

       int choice;
       boolean isRunning = true;
       System.out.println("Welcome to your task manager app!");

       while(isRunning) {


           System.out.println("1.Add a task");
           System.out.println("2.View All tasks");
           System.out.println("3.Mark a task as complete");
           System.out.println("4.Delete a task");
           System.out.println("5.Exit");

           System.out.println("Please choose 1,2,3,4 or 5: ");
           String input = scanner.nextLine();
           try {
               choice = Integer.parseInt(input);

               switch (choice) {
                   case 1:
                       System.out.print("Enter a task: ");
                       String title = scanner.nextLine();
                       taskInterface.addTask(title);
                       System.out.println("Task added.");
                       break;
                   case 2:
                       List<Task> tasks = taskInterface.getAllTasks();

                       if (tasks.isEmpty()) {
                           System.out.println("No tasks found. Your task list is empty.");
                       } else {
                           tasks.forEach(task -> System.out.println(task.getId() + ". " + task.getTitle()));
                       }
                       break;
                   case 3:
                       System.out.println("Enter task number you want to complete: ");
                       int id = scanner.nextInt();
                       boolean completed = taskInterface.completeTask(id);

                       if(completed){
                           System.out.println("Task marked as complete");
                       } else {
                           System.out.println("Task not found / already completed");
                       }
                       scanner.nextLine();
                       break;
                   case 4:
                       System.out.print("Enter task number to delete: ");
                       id = scanner.nextInt();
                       boolean deleted = taskInterface.deleteTask(id);
                       if (deleted) {
                           System.out.println("Task successfully deleted.");
                       } else {
                           System.out.println("Task with ID " + id + " does not exist.");
                       }
                       scanner.nextLine();
                       break;
                   case 5:
                       isRunning = false;
                       System.out.println("Thank you for using the program bye");
                       break;
                   default:
                       System.out.println("Invalid choice. Please select 1,2,3,4 or 5");
                       break;


               }
           } catch (NumberFormatException nfe) {
               System.out.println("Invalid input. Please enter a number.");
           }

       }

       }

    }
