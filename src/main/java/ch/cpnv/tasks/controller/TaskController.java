package ch.cpnv.tasks.controller;
import ch.cpnv.tasks.entity.Task;
import ch.cpnv.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> all() {
        return this.taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> one(@PathVariable Long id) {
        Task task = this.taskService.getTaskById(id);
        if(task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(task);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {
        Task savedTask = this.taskService.createTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Task>  toggleTask(@PathVariable Long id) {
        Task task = this.taskService.getTaskById(id);
        if(task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Task toggledTask = this.taskService.toggleTask(task);
        return ResponseEntity.ok().body(toggledTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
