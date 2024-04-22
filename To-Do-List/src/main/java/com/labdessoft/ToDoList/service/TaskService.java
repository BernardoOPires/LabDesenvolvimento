import java.time.LocalDate;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        validateTaskDate(task.getDueDate());
        return taskRepository.save(task);
    }

    private void validateTaskDate(LocalDate dueDate) {
        if (dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data da tarefa não pode ser anterior à data atual.");
        }
    }
}