import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest {


    @Test
    public void getTitle(){
        Task task = new Task(1,"Reading");
        assertEquals("Reading" , task.getTitle());
    }

    @Test
    public void getId(){
        Task task = new Task(1,"Reading");
        assertEquals(1,task.getId());
    }

    @Test
    public void markCompleted(){
        Task task = new Task(1,"Journaling");
        task.markCompleted();
        assertTrue(task.isCompleted());
    }

    @Test
    public void isCompleted(){
        Task task = new Task(1,"Skipping");
        assertEquals(false,task.isCompleted());
    }

}
