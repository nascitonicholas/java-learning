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

    }

    @Override
    public List<TaskModel> findAll() {
        List<TaskModel> modelsList = new ArrayList<>();
        List<TaskEntity> entities = repository.findAll();
        entities.parallelStream().forEach(enitty -> {
            modelsList.add(TaskMapper.toModel(enitty));
        });
        modelsList.sort(Comparator.comparing(TaskModel::getId));
        return modelsList;
    }

    @Override
    public TaskModel findById(Long taskId) {
        return null;
    }

    @Override
    public void update(TaskModel taskModel) {

    }
}
