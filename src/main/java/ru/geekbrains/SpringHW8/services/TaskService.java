package ru.geekbrains.SpringHW8.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.SpringHW8.aspects.TrackUserAction;
import ru.geekbrains.SpringHW8.model.Task;
import ru.geekbrains.SpringHW8.model.TaskStatus;
import ru.geekbrains.SpringHW8.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository tasksRepository;

    //метод получения всех задач
    @TrackUserAction
    public List<Task> getAllTasks() {
        return tasksRepository.findAll();
    }

    //метод добавления новой задачи
    public Task addTask(Task task) {
        return tasksRepository.save(task);
    }

    //метод получения всех задач с определенным статусом
    public List<Task> getTasksByStatus(TaskStatus status) {
        return tasksRepository.findAllByStatus(status);
    }


    //обновление статуса задачи на следующий по очереди
    public Task updateTaskStatus(Long id) {
        Task newTask = null;
        Optional<Task> task = tasksRepository.findById(id);
        if (task.isPresent()) {
            newTask = task.get();
            if (!(newTask.getStatus().equals(TaskStatus.COMPLETED))) {
                newTask.setStatus(TaskStatus.values()[newTask.getStatus().ordinal() + 1]);
            }
        }
        return tasksRepository.save(newTask);
    }

    //удаление задачи
    @TrackUserAction
    public void deleteTaskById(Long id) {
        tasksRepository.deleteById(id);
    }
}
