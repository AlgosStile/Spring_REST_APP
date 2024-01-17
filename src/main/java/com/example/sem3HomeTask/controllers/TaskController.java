package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер, обрабатывающий запросы к задачам.
 * Предоставляет API для получения списка задач и выполнения
 * различных операций с информацией о пользователях, таких как сортировка,
 * фильтрация и расчет среднего возраста.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final DataProcessingService service;

    /**
     * Создает экземпляр {@code TaskController} с необходимым сервисом обработки данных.
     *
     * @param service сервис для обработки данных пользователей
     */
    @Autowired
    public TaskController(DataProcessingService service) {
        this.service = service;
    }

    /**
     * Возвращает список всех доступных задач.
     *
     * @return список названий задач
     */
    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Сортирует пользователей по возрасту и возвращает отсортированный список.
     *
     * @return отсортированный список пользователей
     */
    @GetMapping("/sort")
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Фильтрует пользователей по заданному критерию возраста и возвращает отфильтрованный список.
     *
     * @param age возраст, по которому осуществляется фильтрация
     * @return объект {@code ResponseEntity}, содержащий список пользователей, отфильтрованных по возрасту
     */
    @GetMapping("/filter/{age}")
    public ResponseEntity<List<User>> filterUsersByAge(@PathVariable("age") int age) {
        List<User> filteredUsers = service.filterUsersByAge(age);
        return ResponseEntity.ok(filteredUsers);
    }

    /**
     * Рассчитывает и возвращает средний возраст всех пользователей.
     *
     * @return объект {@code ResponseEntity}, содержащий средний возраст пользователей
     */
    @GetMapping("/calc")
    public ResponseEntity<Double> calculateAverageAge() {
        double avgAge = service.calculateAverageAge(service.getRepository().getUsers());
        return ResponseEntity.ok(avgAge);
    }
}
