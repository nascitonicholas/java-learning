package br.com.taskmanager.adapter.out.persistence.mapper;

import br.com.taskmanager.adapter.out.persistence.entity.TaskEntity;
import br.com.taskmanager.application.domain.model.TaskModel;

public class TaskMapper {

    public static TaskEntity toEntity(TaskModel model) {
        return TaskEntity.builder()
                .id(model.getId())
                .title(model.getTitle())
                .description(model.getDescription())
                .status(model.getStatus())
                .dueDate(model.getDueDate())
                .createdAt(model.getCreatedAt())
                .updatedAt(model.getUpdatedAt())
                .build();
    }

    public static TaskModel toModel(TaskEntity entity) {
        return TaskModel.create(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus().name(),
                entity.getDueDate(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

}
