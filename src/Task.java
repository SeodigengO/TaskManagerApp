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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted() {
        isCompleted = true;
    }




}
