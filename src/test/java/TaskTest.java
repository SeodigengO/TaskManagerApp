import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


}
