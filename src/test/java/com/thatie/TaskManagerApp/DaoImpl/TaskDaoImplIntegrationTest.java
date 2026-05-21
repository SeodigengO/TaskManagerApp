package com.thatie.TaskManagerApp.DaoImpl;



import com.thatie.TaskManagerApp.DAO.impl.TaskDaoImpl;
import com.thatie.TaskManagerApp.Domain.Task;
import com.thatie.TaskManagerApp.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
public class TaskDaoImplIntegrationTest {

    private TaskDaoImpl underTest;

    @Autowired
    public TaskDaoImplIntegrationTest(TaskDaoImpl underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatTaskCanBeAddedAndRecalled(){
        Task task = TestDataUtil.createTask();
        underTest.addTask(task);
        Optional<Task> result = underTest.getTaskById(task.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(task);
    }

    @Test
    public void testThatTaskCanBeUpdate(){
        Task taskTwo = TestDataUtil.createTaskTwo();
        underTest.addTask(taskTwo);
        taskTwo.setStatus("DONE");
        underTest.updateTask(taskTwo.getId(),taskTwo);
        Optional<Task> result = underTest.getTaskById(taskTwo.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(taskTwo);
    }

    @Test
    public void testThatTaskCanBeCreatedAndRecalled(){
        Task taskTwo = TestDataUtil.createTaskTwo();
        underTest.addTask(taskTwo);
        Task taskThree = TestDataUtil.createTaskThree();
        underTest.addTask(taskThree);
        Task taskFour = TestDataUtil.createTaskFour();
        underTest.addTask(taskFour);
        Task taskFive = TestDataUtil.createTaskFive();
        underTest.addTask(taskFive);

        List<Task> result = underTest.getAllTasks();
        assertThat(result).hasSize(4).containsExactly(taskTwo,taskThree,taskFour,taskFive);
    }

    @Test
    public void testThatTaskCanBeSearchedAndBeFoundOrNot(){
        Task taskTwo = TestDataUtil.createTaskTwo();
        underTest.addTask(taskTwo);
        Task taskThree = TestDataUtil.createTaskThree();
        underTest.addTask(taskThree);
        Task taskFour = TestDataUtil.createTaskFour();
        underTest.addTask(taskFour);
        Task taskFive = TestDataUtil.createTaskFive();
        underTest.addTask(taskFive);

        Optional<Task> result = underTest.getTaskById(1L);
        assertThat(result).isNotPresent();

    }


    @Test
    public void testThatTaskCanBeDeleted(){
        Task taskTwo = TestDataUtil.createTaskTwo();
        underTest.addTask(taskTwo);
        Task taskThree = TestDataUtil.createTaskThree();
        underTest.addTask(taskThree);
        Task taskFour = TestDataUtil.createTaskFour();
        underTest.addTask(taskFour);
        Task taskFive = TestDataUtil.createTaskFive();
        underTest.addTask(taskFive);

        underTest.deleteTask(2L);

        List<Task> result = underTest.getAllTasks();

        assertThat(result).hasSize(3).containsExactly(taskThree,taskFour,taskFive);

    }
}
