package com.thatie.TaskManagerApp;

import com.thatie.TaskManagerApp.Domain.Task;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TestDataUtil {

    private TestDataUtil(){
    }

    public static Task createTask(){
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MICROS);;
        return Task.builder().id(1L).title("Do the dishes").status("TODO").createdAt(now).build();
    }

    public static Task createTaskTwo(){
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MICROS);;
        return Task.builder().id(2L).title("Read 5 pages").status("TODO").createdAt(now).build();
    }

    public static Task createTaskThree(){
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MICROS);;
        return Task.builder().id(3L).title("Do two leg workouts").status("TODO").createdAt(now).build();
    }

    public static Task createTaskFour(){
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MICROS);;
        return Task.builder().id(4L).title("Run 2km").status("TODO").createdAt(now).build();
    }

    public static Task createTaskFive(){
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MICROS);;
        return Task.builder().id(5L).title("Set up C# project").status("TODO").createdAt(now).build();
    }
}
