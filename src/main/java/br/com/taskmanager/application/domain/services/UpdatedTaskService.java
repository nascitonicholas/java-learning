package br.com.taskmanager.application.domain.services;

import br.com.taskmanager.application.domain.mapper.TaskMapper;
import br.com.taskmanager.application.domain.model.TaskModel;
import br.com.taskmanager.application.domain.model.command.TaskCommand;
import br.com.taskmanager.application.domain.model.dto.TaskDto;
import br.com.taskmanager.application.port.out.TaskPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatedTaskService extends TaskManager {

    private final TaskPersistence repository;

    @Override
    public TaskDto updateTask(Long taskId, TaskCommand taskCommand) {
        TaskModel model = repository.findById(taskId);

        if(model == null) {
            return null;
        }

        model.updated(taskCommand.getTitle(),
                taskCommand.getDescription(),
                taskCommand.getStatus(),
                taskCommand.getDueDate());

        TaskModel updatedModel = repository.save(model);

        return TaskMapper.toDto(updatedModel);
    };

}
