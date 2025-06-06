package br.com.taskmanager.application.domain.services;

import br.com.taskmanager.application.domain.model.command.TaskCommand;
import br.com.taskmanager.application.domain.model.dto.TaskDto;
import br.com.taskmanager.application.port.in.CreateTaskUseCase;
import br.com.taskmanager.application.port.in.DeleteTaskUseCase;
import br.com.taskmanager.application.port.in.SearchTaskUseCase;
import br.com.taskmanager.application.port.in.UpdateTaskUseCase;

import java.util.List;

public abstract class TaskManager implements CreateTaskUseCase, DeleteTaskUseCase, SearchTaskUseCase, UpdateTaskUseCase {

    @Override
    public Long createTask(TaskCommand taskCommand) {
        throw new UnsupportedOperationException("Not implemented yet");
    };

    @Override
    public void deleteTask(Long taskId) {
        throw new UnsupportedOperationException("Not implemented yet");
    };

    @Override
    public List<TaskDto> searchTasks() {
        throw new UnsupportedOperationException("Not implemented yet");
    };

    @Override
    public TaskDto searchTaskById(Long taskId) {
        throw new UnsupportedOperationException("Not implemented yet");
    };

    @Override
    public void updateTask(TaskCommand taskCommand) {
        throw new UnsupportedOperationException("Not implemented yet");
    };


}
