package fr.esgi.interfaces;

import fr.esgi.model.User;

import java.util.List;

public interface UserListInterface {
    void addNewUser(User user);
    User getUser(User userConnecting);
    void updateUsers(List<User> users);
    boolean contains(User user);
}
