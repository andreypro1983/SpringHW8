package ru.geekbrains.SpringHW8.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.SpringHW8.model.Task;
import ru.geekbrains.SpringHW8.model.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByStatus(TaskStatus status);

}