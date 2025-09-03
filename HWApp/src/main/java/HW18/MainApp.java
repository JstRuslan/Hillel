package HW18;

import java.util.List;
import java.util.Optional;

public class MainApp {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();

        userRepository.userAdd(
                new User(1, "Ivan", "ivan@gmail.com"),
                new User(2, "Sveta", "sveta@gmail.com"),
                new User(3, "Peter", "peter@gmail.com")
        );

        Optional<User> maybeUser = userRepository.findUserById(2);
        System.out.println("------findUserById-------");
        maybeUser.ifPresent(System.out::println);

        maybeUser = userRepository.findUserByEmail("peter@gmail.com");
        System.out.println("------findUserByEmail------");
        maybeUser.ifPresentOrElse(System.out::println, () -> System.out.println("User not found."));

        Optional<List<User>> maybeUsers = userRepository.findAllUsers();
        System.out.println("------findAllUsers-------");
        maybeUsers.ifPresent(users -> users
                .forEach(System.out::println));
        }
    }
