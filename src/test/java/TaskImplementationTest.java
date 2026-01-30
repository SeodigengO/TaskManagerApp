import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void shouldReturnAListInOrderExpected(){

        underTest.addTask("Read");
        underTest.addTask("Do Dished");

        List<Task> tasks = underTest.getAllTasks();

      assertEquals("Read",tasks.get(0).getTitle());
      assertEquals("Do Dished",tasks.get(1).getTitle());
    }

    @Test
    void shouldReturnAListWithTwoElements() {
        underTest.addTask("Read");
        List<Task> tasks = underTest.getAllTasks();
        assertEquals(1,tasks.size());
    }

}
