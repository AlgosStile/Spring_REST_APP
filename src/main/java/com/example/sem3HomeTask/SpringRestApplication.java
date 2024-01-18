package com.example.sem3HomeTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс запуска Spring Boot приложения.
 * Инициализирует и запускает приложение как стандартное.
 */
@SpringBootApplication
public class SpringRestApplication {

	/**
	 * Точка входа в приложение Spring Boot.
	 * Этот метод запускает Spring Boot приложение, используя Sem3HomeTaskApplication.class в качестве основного конфигурационного класса.
	 * @param args Массив строковых аргументов командной строки, которые могут быть переданы приложению.
	 * Они будут предоставлены компонентам приложения через механизм autowiring, если они будут зарегистрированы как бины.
	 * Также аргументы могут быть использованы для настройки поведения SpringApplication.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

}
