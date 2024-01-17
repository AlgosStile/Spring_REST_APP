package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для обработки данных пользователей.
 * Этот сервис содержит бизнес-логику по работе со списком пользователей,
 * включая сортировку, фильтрацию и подсчет статистических данных.
 */
@Service
public class DataProcessingService {
    private final UserRepository repository;

    /**
     * Конструктор для сервиса, автоматически внедряет необходимый репозиторий.
     * @param repository Экземпляр репозитория, управляющего данными пользователей.
     */
    @Autowired
    public DataProcessingService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Получение экземпляра репозитория.
     * @return Текущий экземпляр репозитория данных пользователей.
     */
    public UserRepository getRepository() {
        return repository;
    }

    /**
     * Сортировка списка пользователей по возрасту.
     * @param users Список пользователей для сортировки.
     * @return Отсортированный список пользователей.
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Фильтрация пользователей по возрастному критерию.
     * @param age Возраст, который пользователи должны превышать.
     * @return Список пользователей старше указанного возраста.
     */
    public List<User> filterUsersByAge(int age) {
        return repository.getUsers().stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Вычисление среднего возраста пользователей.
     * @param users Список пользователей, для которых необходимо вычислить средний возраст.
     * @return Средний возраст пользователей в списке.
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Добавление пользователя в список.
     * @param user Экземпляр пользователя для добавления в список.
     */
    public void addUserToList(User user) {
        repository.getUsers().add(user);
    }

}
