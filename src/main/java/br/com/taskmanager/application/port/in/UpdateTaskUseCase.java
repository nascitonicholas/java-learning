package br.com.taskmanager.application.port.in;

import br.com.taskmanager.application.domain.model.command.TaskCommand;
import br.com.taskmanager.application.domain.model.dto.TaskDto;

public interface UpdateTaskUseCase {

    TaskDto updateTask(Long taskId, TaskCommand taskCommand);

}
