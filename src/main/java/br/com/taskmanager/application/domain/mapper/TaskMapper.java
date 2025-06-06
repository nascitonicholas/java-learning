package br.com.taskmanager.application.domain.mapper;

import br.com.taskmanager.application.domain.model.TaskModel;
import br.com.taskmanager.application.domain.model.command.TaskCommand;
import br.com.taskmanager.application.domain.model.dto.TaskDto;

public class TaskMapper {

    private TaskMapper() {
        // Private constructor to prevent instantiation
    }

    public static TaskModel toModel(TaskCommand command) {
        if (command == null) {
            throw new IllegalArgumentException("TaskCommand cannot be null");
        }

        return TaskModel.create(
                command.getTitle(),
                command.getDescription(),
                command.getStatus(),
                command.getDueDate());
    }

    public static TaskDto toDto(TaskModel model) {
        if (model == null) {
            return null;
        }

        return TaskDto.builder()
                .id(model.getId())
                .title(model.getTitle())
                .description(model.getDescription())
                .status(model.getStatus().name())
                .dueDate(model.getDueDate())
                .updatedAt(model.getUpdatedAt())
                .build();
    }

}
