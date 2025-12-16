package org.summer2025.ruslan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class ShopApp {
    public static void main(String[] args) {
        SpringApplication.run(ShopApp.class, args);
    }

    @Bean
    public CommandLineRunner runner(ProductRepository repository, org.springframework.context.ApplicationContext ctx) {
        return args -> {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                Cart cart = ctx.getBean(Cart.class); // новий екземпляр

                System.out.println("\n=== Menu ===");
                System.out.println("1. Show products");
                System.out.println("2. Add product to cart");
                System.out.println("3. Remove product from cart");
                System.out.println("4. Show cart");
                System.out.println("0. Exit");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> repository.getAllProducts().forEach(System.out::println);
                    case 2 -> {
                        System.out.print("Enter product id: ");
                        int id = scanner.nextInt();
                        cart.addProduct(repository.getProductById(id));
                    }
                    case 3 -> {
                        System.out.print("Enter product id to remove: ");
                        int id = scanner.nextInt();
                        cart.removeProductById(id);
                    }
                    case 4 -> cart.getItems().forEach(System.out::println);
                    case 0 -> {
                        System.out.println("Bye!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid option!");
                }
            }
        };
    }
}