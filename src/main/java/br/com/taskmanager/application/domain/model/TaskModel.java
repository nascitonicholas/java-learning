package br.com.taskmanager.application.domain.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TaskModel {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private TaskModel (String title, String description, String status, String dueDate) {
        this.title = title;
        this.description = description;
        this.status = TaskStatus.valueOf(status);
        this.dueDate = LocalDateTime.parse(dueDate);
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    private TaskModel (Long id, String title, String description, String status, LocalDateTime dueDate, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = TaskStatus.valueOf(status);
        this.dueDate = dueDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static TaskModel create(String title, String description, String status, String dueDate) {
        validate(title, description, status, dueDate);
        return new TaskModel(title, description, status, dueDate);
    }

    public static TaskModel create(Long id, String title, String description, String status, LocalDateTime dueDate, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new TaskModel(id, title, description, status, dueDate, createdAt, updatedAt);
    }

    private static void validate(String title, String description, String status, String dueDate) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if (status.isBlank() || TaskStatus.isValid(status)) {
            throw new IllegalArgumentException("Invalid status provided");
        }
        if (dueDate.isBlank() || LocalDateTime.parse(dueDate).isBefore(LocalDateTime.now()) || !dueDate.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Due date cannot be null or empty and must be in the future and in the format 'yyyy-MM-dd'T'HH:mm:ss'");
        }
    }

}
