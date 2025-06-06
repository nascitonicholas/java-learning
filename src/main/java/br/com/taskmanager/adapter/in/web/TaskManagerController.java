package br.com.taskmanager.adapter.in.web;

import br.com.taskmanager.adapter.in.web.request.TaskRequest;
import br.com.taskmanager.adapter.in.web.response.ApiResponse;
import br.com.taskmanager.application.domain.model.command.TaskCommand;
import br.com.taskmanager.application.domain.model.dto.TaskDto;
import br.com.taskmanager.application.port.in.CreateTaskUseCase;
import br.com.taskmanager.application.port.in.DeleteTaskUseCase;
import br.com.taskmanager.application.port.in.SearchTaskUseCase;
import br.com.taskmanager.application.port.in.UpdateTaskUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskManagerController {

    private final CreateTaskUseCase createTaskUseCase;
    private final SearchTaskUseCase searchTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createTask(@RequestBody TaskRequest request) {
        TaskCommand command = TaskCommand.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(request.getStatus())
                .dueDate(request.getDueDate())
                .build();
        Long idTask = createTaskUseCase.createTask(command);
        URI location = URI.create("/tasks/" + idTask);
        ApiResponse<Void> response = new ApiResponse<>("Task created", null);
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getTasks() {
        List<TaskDto> taskList = searchTaskUseCase.searchTasks();
        ApiResponse<List<TaskDto>> response = new ApiResponse<>("Task search completed successfully.", taskList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<ApiResponse<?>> getTaskById(@PathVariable Long taskId) {
        TaskDto task = searchTaskUseCase.searchTaskById(taskId);
        ApiResponse<TaskDto> response = new ApiResponse<>("Task search by id successful", task);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<ApiResponse<?>> updateTask(@PathVariable Long taskId, @RequestBody TaskRequest request) {
        TaskCommand command = TaskCommand.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(request.getStatus())
                .dueDate(request.getDueDate())
                .build();
        TaskDto updatedTask = updateTaskUseCase.updateTask(taskId, command);
        ApiResponse<TaskDto> response = new ApiResponse<>("Task created", updatedTask);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        deleteTaskUseCase.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

}
