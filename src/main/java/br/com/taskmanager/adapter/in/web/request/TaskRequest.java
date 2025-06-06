package br.com.taskmanager.adapter.in.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {
    @NotBlank(message = "O título é obrigatório, não pode ser vazio ou nulo")
    private String title;
    @NotBlank(message = "A descrição é obrigatória, não pode ser vazio ou nulo")
    private String description;
    @NotBlank(message = "O status é obrigatório, não pode ser vazio ou nulo")
    private String status;
    @NotBlank(message = "A data de vencimento é obrigatória, não pode ser vazio ou nulo")
    @Pattern(
            regexp = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}",
            message = "A data deve estar no formato yyyy-MM-dd'T'HH:mm:ss"
    )
    private String dueDate;
}
