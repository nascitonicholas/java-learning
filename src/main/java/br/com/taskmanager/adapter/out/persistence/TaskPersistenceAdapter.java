package br.com.taskmanager.adapter.out.persistence;

import br.com.taskmanager.adapter.out.persistence.entity.TaskEntity;
import br.com.taskmanager.adapter.out.persistence.mapper.TaskMapper;
import br.com.taskmanager.adapter.out.persistence.repository.TaskRepository;
import br.com.taskmanager.application.domain.model.TaskModel;
import br.com.taskmanager.application.port.out.TaskPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TaskPersistenceAdapter implements TaskPersistence {

    private final TaskRepository repository;

    @Override
    public TaskModel save(TaskModel taskModel) {
        TaskEntity entity = TaskMapper.toEntity(taskModel);
        return TaskMapper.toModel(repository.save(entity));
    }

    @Override
    public void delete(Long taskId) {
        repository.deleteById(taskId);
    }

    @Override
    public List<TaskModel> findAll() {
        List<TaskEntity> entities = repository.findAll();
        return entities.stream()
                .map(TaskMapper::toModel)
                .sorted(Comparator.comparing(TaskModel::getId))
                .toList();
    }

    @Override
    public TaskModel findById(Long taskId) {
        Optional<TaskEntity> entity = repository.findById(taskId);
        return entity.map(TaskMapper::toModel).orElse(null);
    }

    @Override
    public void update(TaskModel taskModel) {
        TaskEntity entity = TaskMapper.toEntity(taskModel);
        repository.save(entity);
    }
}
