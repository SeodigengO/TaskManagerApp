import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskImplementationTest {

    private static TaskImplementation underTest;
    @BeforeEach
    void setup() {
        underTest = new TaskImplementation();
    }

    @Test
    public void shouldReturntaskAdded()
    {
        String addedTask = underTest.addTask("Jumping");
        assertEquals("Jumping", addedTask);
    }

    @Test
    public void shouldReturnAllTaskAddedInOrder(){

        underTest.addTask("Read");
        underTest.addTask("Do Dished");

        List<Task> tasks = underTest.getAllTasks();

      assertEquals("Read",tasks.get(0).getTitle());
      assertEquals("Do Dished",tasks.get(1).getTitle());
    }

    @Test
    public void shouldReturnAListSize() {
        underTest.addTask("Read");
        underTest.addTask("Jump");
        List<Task> tasks = underTest.getAllTasks();
        assertEquals(2,tasks.size());
    }

    @Test
    public void deleteTask_existingId_returnsTrue() {
        underTest.addTask("Read");
        underTest.addTask("Code");
        
        boolean result = underTest.deleteTask(1);
        
        assertTrue(result);
        assertEquals(1, underTest.getAllTasks().size());
        assertEquals("Code", underTest.getAllTasks().get(0).getTitle());
    }

    @Test
    public void deleteTask_nonExistingId_returnsFalse() {
        
        underTest.addTask("Read");
        boolean result = underTest.deleteTask(9);
        
        assertFalse(result);
        assertEquals(1, underTest.getAllTasks().size());
    }


}
