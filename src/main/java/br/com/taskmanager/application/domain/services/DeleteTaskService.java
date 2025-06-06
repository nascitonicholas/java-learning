package br.com.taskmanager.application.domain.services;

import br.com.taskmanager.application.port.out.TaskPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteTaskService extends TaskManager {

    private final TaskPersistence repository;

    @Override
    public void deleteTask(Long taskId) {
        repository.delete(taskId);
    };

}
