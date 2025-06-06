package br.com.taskmanager.adapter.in.web;

import br.com.taskmanager.adapter.in.web.request.TaskRequest;
import br.com.taskmanager.adapter.in.web.response.ApiResponse;
import br.com.taskmanager.application.domain.model.command.TaskCommand;
import br.com.taskmanager.application.domain.model.dto.TaskDto;
import br.com.taskmanager.application.port.in.CreateTaskUseCase;
import br.com.taskmanager.application.port.in.DeleteTaskUseCase;
import br.com.taskmanager.application.port.in.SearchTaskUseCase;
import br.com.taskmanager.application.port.in.UpdateTaskUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
@Tag(name = "Tasks", description = "Administração de tarefas")
public class TaskManagerController {

    private final CreateTaskUseCase createTaskUseCase;
    private final SearchTaskUseCase searchTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;

    @PostMapping
    @Operation(summary = "Cria uma nova tarefa")
    public ResponseEntity<ApiResponse<?>> createTask(@Valid @RequestBody TaskRequest request) {
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
    @Operation(summary = "Busca todas as tarefas")
    public ResponseEntity<ApiResponse<?>> getTasks() {
        List<TaskDto> taskList = searchTaskUseCase.searchTasks();
        ApiResponse<List<TaskDto>> response = new ApiResponse<>("Task search completed successfully.", taskList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{taskId}")
    @Operation(summary = "Busca uma tarefa pelo ID")
    public ResponseEntity<ApiResponse<?>> getTaskById(@NotBlank(message = "O id não pode ser vazio ou nulo")  @PathVariable Long taskId) {
        TaskDto task = searchTaskUseCase.searchTaskById(taskId);
        ApiResponse<TaskDto> response = new ApiResponse<>("Task search by id successful", task);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{taskId}")
    @Operation(summary = "Atualiza uma tarefa pelo ID")
    public ResponseEntity<ApiResponse<?>> updateTask(@NotBlank(message = "O id não pode ser vazio ou nulo") @PathVariable Long taskId, @Valid @RequestBody TaskRequest request) {
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
    @Operation(summary = "Deleta uma tarefa pelo ID")
    public ResponseEntity<Void> deleteTask(@NotBlank(message = "O id não pode ser vazio ou nulo") @PathVariable Long taskId) {
        deleteTaskUseCase.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

}
