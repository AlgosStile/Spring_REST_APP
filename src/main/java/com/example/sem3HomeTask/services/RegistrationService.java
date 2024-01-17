package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис, отвечающий за регистрацию пользователей.
 * Этот класс интегрирует работу нескольких сервисов для обработки регистрации пользователя,
 * включая его создание, добавление в список и отправку уведомлений.
 */
@Service
public class RegistrationService {

    private final UserService userService;
    private final NotificationService notificationService;
    private final DataProcessingService dataProcessingService;

    /**
     * Создает экземпляр сервиса регистрации, инжектируя зависимости.
     * @param userService Сервис для управления данными пользователя.
     * @param notificationService Сервис для отправки уведомлений пользователям.
     * @param dataProcessingService Сервис для обработки данных пользователей и их регистрации.
     */
    @Autowired
    public RegistrationService(UserService userService, NotificationService notificationService, DataProcessingService dataProcessingService) {
        this.userService = userService;
        this.notificationService = notificationService;
        this.dataProcessingService = dataProcessingService;
    }

    /**
     * Обрабатывает регистрацию пользователя, создавая нового пользователя,
     * добавляя его в список и отправляя уведомление.
     * Метод создает нового пользователя исходя из предоставленных данных,
     * добавляет пользователя в хранилище и оповещает пользователя
     * через сервис уведомлений.
     * @param name Имя нового пользователя.
     * @param age Возраст нового пользователя.
     * @param email Электронная почта нового пользователя.
     * @return Экземпляр зарегистрированного пользователя.
     */
    public User processRegistration(String name, int age, String email) {
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(newUser);
        notificationService.notifyUser(newUser);
        return newUser;
    }

    /**
     * Возвращает сервис для обработки данных пользователей.
     * @return Текущий экземпляр сервиса обработки данных пользователей.
     */
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * Возвращает список всех пользователей, зарегистрированных в системе.
     * @return Список зарегистрированных пользователей.
     */
    public List<User> getAllUsers() {
        return dataProcessingService.getRepository().getUsers();
    }
}