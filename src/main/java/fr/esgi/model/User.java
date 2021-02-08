package fr.esgi.model;

import fr.esgi.enumeration.Role;
import fr.esgi.interfaces.UserInterface;

import java.util.Arrays;

public class User implements UserInterface {
    private String login;
    private Role role;

    private Book[] books = new Book[3];

    // Add default constructor for Jackson (JSON)
    public User() {}

    public User(String login) {
        this.role = Role.Guest;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Book[] getBooks() {
        return books;
    }

    @Override
    public void referenceBook(Library library, String bookName, String authorName) {
        if (role.equals(Role.Librarian)) {
            Book book = new Book(bookName, new Author(authorName));
            library.addBook(book);
        }
    }

    @Override
    public void borrowBook(Library library, Book book) {
        if (!role.equals(Role.Guest)) {
            for(int i = 0; i < 3; i++){
                if(books[i] == null){
                    books[i] = library.borrowBook(book);
                    return;
                }
            }
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof User) {
            User userInput = (User) object;

            return this.getLogin().equals((userInput.getLogin()));
        }

        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", role=" + role +
                ", books=" + Arrays.toString(books) +
                '}';
    }
}
