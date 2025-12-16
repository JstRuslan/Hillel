package org.summer2025.ruslan;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringJDBCApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringJDBCApp.class, args);

        while (true) {

        }
    }

    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
        return args -> {


//            // Додаємо кілька записів
//            jdbcTemplate.update("INSERT INTO Customer (full_name, email, social_security_number) VALUES (?, ?, ?)",
//                    "Іван Петренко", "ivan.petrenko@example.com", "SSN001");
//            jdbcTemplate.update("INSERT INTO Customer (full_name, email, social_security_number) VALUES (?, ?, ?)",
//                    "Олена Коваль", "olena.koval@example.com", "SSN002");
//            jdbcTemplate.update("INSERT INTO Customer (full_name, email, social_security_number) VALUES (?, ?, ?)",
//                    "Сергій Бондар", "serhiy.bondar@example.com", "SSN003");
//
//            System.out.println("✅ Дані додано у таблицю Customer");
        };


    }
}