package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс контроллера, обеспечивающий обработку HTTP-запросов к эндпоинтам, связанным с пользователями.
 * Он предоставляет методы для добавления новых пользователей в систему и получения списка зарегистрированных пользователей.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final RegistrationService service;

    /**
     * Внедряет экземпляр сервиса, обрабатывающего регистрацию пользователей, через конструктор.
     *
     * @param service Сервис, управляющий регистрацией пользователей.
     */
    @Autowired
    public UserController(RegistrationService service) {
        this.service = service;
    }

    /**
     * Обрабатывает POST-запросы на создание нового пользователя с данными, полученными в JSON теле запроса.
     *
     * @param user Объект пользователя, содержащий данные, которые необходимо зарегистрировать.
     * @return {@code ResponseEntity<User>} содержащее зарегистрированного пользователя и статус HTTP CREATED.
     */
    @PostMapping("/body")
    public ResponseEntity<User> userAddFromBody(@RequestBody User user) {
        User newUser = service.processRegistration(user.getName(), user.getAge(), user.getEmail());
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    /**
     * Обрабатывает GET-запросы для получения списка всех зарегистрированных пользователей.
     *
     * @return {@code ResponseEntity<List<User>>} содержащее список зарегистрированных пользователей и статус HTTP OK.
     */
    @GetMapping
    public ResponseEntity<List<User>> userList() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    /**
     * Обрабатывает POST-запросы для создания нового пользователя с параметрами, переданными через строку запроса.
     *
     * @param name Имя пользователя для регистрации.
     * @param age Возраст пользователя для регистрации.
     * @param email Электронная почта пользователя для регистрации.
     * @return {@code ResponseEntity<User>} содержащее зарегистрированного пользователя и статус HTTP CREATED.
     */
    @PostMapping("/params")
    public ResponseEntity<User> userAddFromParams(@RequestParam String name, @RequestParam int age, @RequestParam String email) {
        User newUser = service.processRegistration(name, age, email);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
