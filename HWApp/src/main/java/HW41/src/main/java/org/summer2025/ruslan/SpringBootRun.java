package org.summer2025.ruslan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.summer2025.ruslan.Entity.Product;
import org.summer2025.ruslan.Repository.ProductRepository;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootRun {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRun.class, args);
    }

//    @Bean
//    CommandLineRunner initDatabase(ProductRepository productRepository) {
//        return args -> {
//            Product p1 = new Product("Солянка", 1200.0);
//            Product p2 = new Product("Відбивна", 800.0);
//            Product p3 = new Product("Картошка", 150.0);
//            Product p4 = new Product("Соус", 70.0);
//            Product p5 = new Product("Чай", 50.0);
//        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5)); }; }
}