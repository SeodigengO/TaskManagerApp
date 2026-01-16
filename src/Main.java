import java.util.Scanner;

public class Main{
   public static void main(String[] args){

       TaskInterface taskInterface = new TaskService();

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
               System.out.print("Enter task title: ");
               String title = scanner.nextLine();
               taskInterface.addTask(title);
               System.out.println("Task added.");
           } else if (choice == 2) {
               taskInterface.getAllTasks().forEach(task -> System.out.println(task.getId() + ". " + task.getTitle()));
           } else if (choice == 3) {
               System.out.println("Complete");
           } else if (choice == 4) {
               int id = scanner.nextInt();
               taskInterface.deleteTask(id);
               System.out.println("Task successfully deleted");
           }
           else{
               isRunning = false;
               System.out.println("Thank you for using the program bye");
           }
       }

    }
}