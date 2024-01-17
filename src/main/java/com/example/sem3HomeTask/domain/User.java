package com.example.sem3HomeTask.domain;

/**
 * Класс, представляющий сущность пользователя в системе.
 * Каждый пользователь характеризуется именем, возрастом и электронной почтой.
 * Данный класс предоставляет методы для доступа и управления этими полями.
 */
public class User {

    /** Имя пользователя.
     */
    private String name;

    /** Возраст пользователя.
     */
    private int age;

    /** Электронная почта пользователя.
     */
    private String email;

    /**
     * Получает имя пользователя.
     * @return Текущее имя пользователя.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя пользователя.
     * @param name Новое имя пользователя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получает возраст пользователя.
     * @return Текущий возраст пользователя.
     */
    public int getAge() {
        return age;
    }

    /**
     * Устанавливает возраст пользователя.
     * @param age Новый возраст пользователя.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Получает электронную почту пользователя.
     * @return Текущая электронная почта пользователя.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Устанавливает электронную почту пользователя.
     * @param email Новый адрес электронной почты пользователя.
     */
    public void setEmail(String email) {
        this.email = email;
    }


}
