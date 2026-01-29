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
    public void addTaskTest()
    {
        String addedTask = underTest.addTask("Jumping");
        assertEquals("Jumping", addedTask);
    }


}
