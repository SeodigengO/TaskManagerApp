import java.util.List;
import java.util.Scanner;

public class Main{
   public static void main(String[] args){

       TaskInterface taskInterface = new TaskImplementation();

       Scanner scanner = new Scanner(System.in);

       int choice;
       boolean isRunning = true;

       while(isRunning){
           System.out.println("Welcome to your task manager app!");

           System.out.println("1.Add a task");
           System.out.println("2.View All tasks");
           System.out.println("3.Mark a task as complete");
           System.out.println("4.Delete a task");
           System.out.println("5.Exit");

           System.out.println("Please choose 1,2,3,4 or 5: ");
           choice = scanner.nextInt();
           scanner.nextLine();

           if(choice == 1){
                   System.out.print("Enter a task: ");
                   String title = scanner.nextLine();
                   taskInterface.addTask(title);
                   System.out.println("Task added.");
               }
           else if (choice == 2) {
               List<Task> tasks = taskInterface.getAllTasks();

               if (tasks.isEmpty()) {
                   System.out.println("No tasks found. Your task list is empty.");
               } else {
                   tasks.forEach(task -> System.out.println(task.getId() + ". " + task.getTitle()));
               }

           } else if (choice == 3) {
               System.out.println("Enter task number you want to complete: ");
               int id = scanner.nextInt();
               taskInterface.completeTask(id);
               System.out.println("Task is complete");
               scanner.nextLine();
           } else if (choice == 4) {
               System.out.print("Enter task number to delete: ");
               int id = scanner.nextInt();
               boolean deleted = taskInterface.deleteTask(id);
               if(deleted){
                   System.out.println("Task successfully deleted.");
               }
               else {
                   System.out.println("Task with ID " + id + " does not exist.");
               }
           }
           else if(choice != 1 || choice != 2 || choice != 3 || choice != 4 || choice != 5 ){
               System.out.println("Invalid choice. Please select 1,2,3,4 or 5");
           }

           else{
               isRunning = false;
               System.out.println("Thank you for using the program bye");
           }
       }

    }

}