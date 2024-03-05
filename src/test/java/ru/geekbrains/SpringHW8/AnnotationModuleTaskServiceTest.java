package ru.geekbrains.SpringHW8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.geekbrains.SpringHW8.model.Task;
import ru.geekbrains.SpringHW8.model.TaskStatus;
import ru.geekbrains.SpringHW8.repositories.TaskRepository;
import ru.geekbrains.SpringHW8.services.TaskService;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;



@ExtendWith(MockitoExtension.class)
public class AnnotationModuleTaskServiceTest {
    @Mock
    private TaskRepository taskRepository;
    @InjectMocks
    private TaskService taskService;


    //Проверка для задачи со статусом отличным от COMPLETED
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

    @Test
    @DisplayName("updateTaskStatusCompleted")
    public void updateTaskStatusCompletedTest(){

        // Подготовка
        Task task = new Task();
        task.setId(4L);
        task.setText("Проверка обновления статуса выполненной задачи");
        task.setStatus(TaskStatus.COMPLETED);
        task.setCreateDate(LocalDateTime.now());
        given(taskRepository.findById(4L)).willReturn(Optional.of(task));
        given(taskRepository.save(task)).willReturn(task);


        // Вызов
        Task newTask = taskService.updateTaskStatus(4L);

        //Проверка
        verify(taskRepository).findById(4L);
        assertEquals(newTask.getStatus(),TaskStatus.COMPLETED);

    }
}
