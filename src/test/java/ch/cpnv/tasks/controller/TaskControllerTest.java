package ch.cpnv.tasks.controller;

import ch.cpnv.tasks.entity.Task;
import ch.cpnv.tasks.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Autowired
    private ObjectMapper objectMapper;

    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
        task.setId(1L);
        task.setDescription("Test Task");
        task.setCompleted(false);
    }

    @Test
    void testGetAllTasks() throws Exception {
        given(taskService.getAllTasks()).willReturn(Arrays.asList(task));

        mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description").value(task.getDescription()));
    }

    @Test
    void testGetTaskById() throws Exception {
        given(taskService.getTaskById(anyLong())).willReturn(task);

        mockMvc.perform(get("/api/tasks/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value(task.getDescription()));
    }

    @Test
    void testCreateTask() throws Exception {
        given(taskService.createTask(any(Task.class))).willReturn(task);

        mockMvc.perform(post("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.description").value(task.getDescription()));
    }

    @Test
    void testUpdateTask() throws Exception {
        given(taskService.updateTask(anyLong(), any(Task.class))).willReturn(task);

        mockMvc.perform(put("/api/tasks/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value(task.getDescription()));
    }

    @Test
    void testToggleTask() throws Exception {
        Task toggledTask = new Task();
        toggledTask.setId(1L);
        toggledTask.setDescription("Test Task");
        toggledTask.setCompleted(true);

        given(taskService.getTaskById(anyLong())).willReturn(task);
        given(taskService.toggleTask(any(Task.class))).willReturn(toggledTask);

        mockMvc.perform(patch("/api/tasks/{id}/toggle", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.completed").value(toggledTask.getCompleted()));
    }

    @Test
    void testDeleteTask() throws Exception {
        doNothing().when(taskService).deleteTask(anyLong());

        mockMvc.perform(delete("/api/tasks/{id}", 1L))
                .andExpect(status().isOk());
    }
}
