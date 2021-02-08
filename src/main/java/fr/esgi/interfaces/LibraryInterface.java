package fr.esgi.interfaces;

import fr.esgi.model.Book;

public interface LibraryInterface {
    void addBook(Book book);
    Book seeBook(Book book);
    Boolean borrowBook(Book book);
}
