package ru.geekbrains.SpringHW8.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(basePackages = "ru.geekbrains.SpringHW8")
@EnableAspectJAutoProxy
public class ProjectConfiguration {}
