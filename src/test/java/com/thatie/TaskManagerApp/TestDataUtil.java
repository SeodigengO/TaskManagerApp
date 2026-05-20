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
}
