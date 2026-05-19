package com.thatie.TaskManagerApp.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    private Long id;
    private String title;
    private String status;
    private LocalDateTime createdAt;
}