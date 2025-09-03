package HW18;

import java.util.*;
import java.util.stream.Collectors;

public class UserRepository {
    private List<User> usersList = new ArrayList<>();
    ;

    void userAdd(User... users) {
        Collections.addAll(usersList, users);
    }

    void userDelete(int id) {
        Optional<User> maybeUser = findUserById(id);
        maybeUser.ifPresent(user -> usersList.remove(user));
    }

    Optional<User> findUserById(int id) {
        return usersList.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    Optional<User> findUserByEmail(String email) {
        Optional<User> maybeUser = usersList.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
        return maybeUser;

    }

    Optional<List<User>> findAllUsers() {
        List<User> listUsers = usersList.stream()
                .collect(Collectors.toList());
        return Optional.ofNullable(listUsers);
    }
}
