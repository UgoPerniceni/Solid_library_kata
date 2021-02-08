package fr.esgi.interfaces;

import fr.esgi.model.Book;

import java.util.List;

public interface LibraryInterface {
    void addBook(Book book);
    void updateBooks(List<Book> books);
    Book getBookByTitle(String title);
    Book borrowBook(Book book);
    boolean contains(String bookTitle);
}
