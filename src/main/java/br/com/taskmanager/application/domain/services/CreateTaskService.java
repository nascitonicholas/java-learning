package br.com.taskmanager.application.domain.services;

import br.com.taskmanager.application.domain.mapper.TaskMapper;
import br.com.taskmanager.application.domain.model.TaskModel;
import br.com.taskmanager.application.domain.model.command.TaskCommand;
import br.com.taskmanager.application.port.out.TaskPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTaskService extends TaskManager {

    private final TaskPersistence taskRepository;

    @Override
    public Long createTask(TaskCommand taskCommand) {
        TaskModel taskModel  = TaskMapper.toModel(taskCommand);
        TaskModel resultModel = taskRepository.save(taskModel);
        return resultModel.getId();
    }

}
