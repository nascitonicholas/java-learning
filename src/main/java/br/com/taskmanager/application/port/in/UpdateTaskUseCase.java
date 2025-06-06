package br.com.taskmanager.application.port.in;

import br.com.taskmanager.application.domain.model.command.TaskCommand;

public interface UpdateTaskUseCase {

    void updateTask(TaskCommand taskCommand);

}
