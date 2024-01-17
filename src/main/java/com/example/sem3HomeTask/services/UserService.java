package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс сервиса, предоставляющий функциональность по созданию пользователей.
 * Этот сервис инкапсулирует логику создания объекта пользователя и управления его свойствами.
 */
@Service
public class UserService {

    private final NotificationService notificationService;

    /**
     * Конструктор для создания сервиса управления пользователями.
     * @param notificationService служба для отправки уведомлений пользователям
     */
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Создает и возвращает новый объект пользователя, используя предоставленные данные.
     * @param name имя пользователя, которое будет установлено для нового объекта пользователя
     * @param age возраст пользователя, который будет установлен для нового объекта пользователя
     * @param email электронная почта пользователя, которая будет установлена для нового объекта пользователя
     * @return возвращает новосозданный объект пользователя с заданными атрибутами
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        return user;
    }
}