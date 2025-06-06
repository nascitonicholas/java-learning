package br.com.taskmanager.application.domain.model.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskCommand {
    private String title;
    private String description;
    private String status;
    private String dueDate;
}
