package br.com.taskmanager.application.port.out;

import br.com.taskmanager.application.domain.model.TaskModel;

import java.util.List;

public interface TaskPersistence {

    TaskModel save(TaskModel taskModel);

    void delete(Long taskId);

    List<TaskModel> findAll();

    TaskModel findById(Long taskId);

    void update(TaskModel taskModel);

}
