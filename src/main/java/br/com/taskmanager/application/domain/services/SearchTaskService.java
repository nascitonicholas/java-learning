package br.com.taskmanager.application.domain.services;

import br.com.taskmanager.application.domain.mapper.TaskMapper;
import br.com.taskmanager.application.domain.model.TaskModel;
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
        List<TaskModel> modelList = taskRepository.findAll();
        return modelList.stream()
                .map(TaskMapper::toDto)
                .toList();
    };

    @Override
    public TaskDto searchTaskById(Long taskId) {
        TaskModel model = taskRepository.findById(taskId);
        return TaskMapper.toDto(model);
    };

}
