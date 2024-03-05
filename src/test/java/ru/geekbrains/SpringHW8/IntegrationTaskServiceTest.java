package ru.geekbrains.SpringHW8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.SpringHW8.model.Task;
import ru.geekbrains.SpringHW8.model.TaskStatus;
import ru.geekbrains.SpringHW8.repositories.TaskRepository;
import ru.geekbrains.SpringHW8.services.TaskService;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class IntegrationTaskServiceTest {

    @MockBean
    private TaskRepository taskRepository;
    @Autowired
    private TaskService taskService;


    //Интеграционное тестирование для задачи со статусом отличным от COMPLETED
    @Test
    @DisplayName("updateTaskStatusChange")
    public void updateTaskStatusChangeTest(){

        // Подготовка
        Task task = new Task();
        task.setId(3L);
        task.setText("Проверка обновления статуса задачи");
        task.setStatus(TaskStatus.NOT_STARTED);
        task.setCreateDate(LocalDateTime.now());
        given(taskRepository.findById(3L)).willReturn(Optional.of(task));
        given(taskRepository.save(task)).willReturn(task);


        // Вызов
        Task newTask = taskService.updateTaskStatus(3L);

        //Проверка
        verify(taskRepository).findById(3L);
        assertEquals(newTask.getStatus(),TaskStatus.IN_PROGRESS);

    }
}
