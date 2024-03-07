package ru.geekbrains.SpringHW8.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text", nullable = false)
    private String text;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "status")
    private TaskStatus status;
    @Column(name = "create_date")
    private LocalDateTime createDate = LocalDateTime.now();

}
