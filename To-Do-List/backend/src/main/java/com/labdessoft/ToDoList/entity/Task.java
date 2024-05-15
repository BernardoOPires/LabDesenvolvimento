package com.labdessoft.ToDoList.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.web.bind.annotation.Schema;  
import java.time.temporal.ChronoUnit;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição não pode ser vazia.")
    @Size(min = 10, message = "Descrição da tarefa deve possuir pelo menos 10 caracteres")
    @Schema(name = "Detalhes da tarefa")
    private String description;

    private Boolean completed;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private TaskType type;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @Schema(name = "Dia para o prazo")
    @Transient
    public Long getDaysRemaining() {
        if (dueDate != null) {
            return LocalDate.now().until(dueDate, ChronoUnit.DAYS);
        }
        return null;
    }

    @Schema(name = "Tipo: alto, medio ,baixo")
    public enum TaskPriority {
        HIGH, MEDIUM, LOW
    }

    @Schema(name = "Tipo: prazo, data ,livre")
    public enum TaskType {
        WITH_DEADLINE, FIXED_DATE, FREE
    }

    
    public Task(String description) {
        this.description = description;
        this.completed = false; 
    }

    @Override
    public String toString() {
        return "Task[id=" + id + ", description=" + description + ", completed=" + completed +
                ", startDate=" + startDate + ", dueDate=" + dueDate + ", type=" + type + "]";
    }
}
