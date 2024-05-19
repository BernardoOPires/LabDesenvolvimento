package com.labdessoft.ToDoList.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Transient;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;
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
