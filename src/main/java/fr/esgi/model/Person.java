package fr.esgi.model;

import fr.esgi.enumeration.Role;
import fr.esgi.interfaces.PersonInterface;

public class Person implements PersonInterface {
    private String login;
    private Role role;

    private final Book[] books = new Book[3];

    public Person(String login) {
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

    @Override
    public void referenceBook(Library library, String bookName, String authorName) {
        if(role.equals(Role.Librarian)){
            Book book = new Book(bookName, new Author(authorName));
            library.addBook(book);
        }
    }

    @Override
    public void borrowBook(Library library, String bookName, String authorName) {
        if(!role.equals(Role.Guest)){
            Book book = new Book(bookName, new Author(authorName));
            if(library.borrowBook(book)){
                if(books.length < 4){
                    books[books.length - 1] = book;
                }
            }
        }
    }
}
