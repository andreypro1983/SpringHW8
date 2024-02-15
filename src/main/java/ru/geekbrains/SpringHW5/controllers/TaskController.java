package ru.geekbrains.SpringHW5.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SpringHW5.model.Task;
import ru.geekbrains.SpringHW5.model.TaskStatus;
import ru.geekbrains.SpringHW5.services.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    //вывести все задачи
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    //добавление задачи
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    //выборка всех задач с определенным статусом
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }

    //обновление статуса задачи на следующий по порядку
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id) {
        return taskService.updateTaskStatus(id);
    }

    //удаление задачи
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }
}
