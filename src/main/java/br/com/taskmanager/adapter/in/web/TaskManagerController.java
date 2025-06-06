package br.com.taskmanager.adapter.in.web;

import br.com.taskmanager.adapter.in.web.request.TaskRequest;
import br.com.taskmanager.adapter.in.web.response.ApiResponse;
import br.com.taskmanager.application.domain.model.command.TaskCommand;
import br.com.taskmanager.application.domain.model.dto.TaskDto;
import br.com.taskmanager.application.port.in.CreateTaskUseCase;
import br.com.taskmanager.application.port.in.SearchTaskUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskManagerController {

    private final CreateTaskUseCase createTaskUseCase;
    private final SearchTaskUseCase searchTaskUseCase;

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
        ApiResponse<List<TaskDto>> response = new ApiResponse<>("Task created", taskList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{taskId}")
    public String getTaskById(@PathVariable Long taskId) {
        // Logic to retrieve tasks
        return "List of tasks";
    }

    @PutMapping("/{taskId}")
    public String updateTask(@PathVariable Long taskId) {
        // Logic to retrieve tasks
        return "List of tasks";
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable Long taskId) {
        // Logic to delete a task
        return "Task with ID " + taskId + " deleted successfully";
    }

}
