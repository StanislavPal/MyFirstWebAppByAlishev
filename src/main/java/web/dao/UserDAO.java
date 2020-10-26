package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static int USER_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++USER_COUNT, "Elton", "John", 55));
        users.add(new User(++USER_COUNT, "Tom", "Cat", 43));
        users.add(new User(++USER_COUNT, "Jerry", "Mouse", 35));
        users.add(new User(++USER_COUNT, "Angelina", "Jolly", 67));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(new User());
    }

    public void delUserById(int id) {
        users.remove(getUserById(id));
    }
}
