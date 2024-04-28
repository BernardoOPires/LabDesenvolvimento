package com.labdessoft.roteiro01.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

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

    @Schema(name = "Dia para o prazo")
    @Transient
    public Long getDaysRemaining() {
        return dueDate != null ? LocalDate.now().until(dueDate).getDays() : null;
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
