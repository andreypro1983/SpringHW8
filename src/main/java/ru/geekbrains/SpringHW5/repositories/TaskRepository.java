package ru.geekbrains.SpringHW5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.SpringHW5.model.Task;
import ru.geekbrains.SpringHW5.model.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByStatus(TaskStatus status);

}