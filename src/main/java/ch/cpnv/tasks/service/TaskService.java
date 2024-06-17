
package ch.cpnv.tasks.service;

import ch.cpnv.tasks.entity.Task;
import ch.cpnv.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return this.taskRepository.findAll();
    }

    public Task getTaskById(long id) {
        return this.taskRepository.findById(id).orElse(null);
    }

    public Task createTask(Task task) {
        return this.taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        task.setId(id);
        return this.taskRepository.save(task);
    }

    public Task toggleTask(Task task) {
        task.setCompleted(!task.getCompleted());
        return this.taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        this.taskRepository.deleteById(id);
    }
}
