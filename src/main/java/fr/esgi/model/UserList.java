package fr.esgi.model;

import fr.esgi.interfaces.UserListInterface;

import java.util.ArrayList;
import java.util.List;

public class UserList implements UserListInterface {
    List<User> users;

    public UserList(){
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public void addNewUser(User user){
        users.add(user);
    }

    @Override
    public User getUser(User userConnecting){
        for(User user: users){
            if(user.equals(userConnecting)){
                return user;
            }
        }

        return null;
    }

    @Override
    public void updateUsers(List<User> users){
        this.users = new ArrayList<>(users);
    }

    @Override
    public boolean contains(User user) {
        return users.contains(user);
    }

    @Override
    public String toString() {
        return "UserList{" +
                "users=" + users +
                '}';
    }
}
