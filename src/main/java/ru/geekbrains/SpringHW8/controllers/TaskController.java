package ru.geekbrains.SpringHW8.controllers;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SpringHW8.model.Task;
import ru.geekbrains.SpringHW8.model.TaskStatus;
import ru.geekbrains.SpringHW8.services.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    // Добавление собственной метрики - счетчика для отслеживания
    private final Counter addTaskCounter = Metrics.counter("my_add_new_task_counter");

    private TaskService taskService;

    //вывести все задачи
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    //добавление задачи
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        // Увеличение счетчика для мониторинга
        addTaskCounter.increment();
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
