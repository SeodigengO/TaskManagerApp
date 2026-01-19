public class Task {

    private int id;
    private String title;
    private boolean isCompleted;

    Task(int id, String title){
        this.id = id;
        this.title = title;
        this.isCompleted = false;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
}
