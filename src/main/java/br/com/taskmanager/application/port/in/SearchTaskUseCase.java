package br.com.taskmanager.application.port.in;

import br.com.taskmanager.application.domain.model.dto.TaskDto;

import java.util.List;

public interface SearchTaskUseCase {

    List<TaskDto> searchTasks();
    TaskDto searchTaskById(Long taskId);

}
