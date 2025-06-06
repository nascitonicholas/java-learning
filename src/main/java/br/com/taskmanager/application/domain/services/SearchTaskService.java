package br.com.taskmanager.application.domain.services;

import br.com.taskmanager.application.domain.model.dto.TaskDto;
import br.com.taskmanager.application.port.out.TaskPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchTaskService extends TaskManager {

    private final TaskPersistence taskRepository;

    @Override
    public List<TaskDto> searchTasks() {
        throw new UnsupportedOperationException("Not implemented yet");
    };

    @Override
    public TaskDto searchTaskById(Long taskId) {
        throw new UnsupportedOperationException("Not implemented yet");
    };

}
