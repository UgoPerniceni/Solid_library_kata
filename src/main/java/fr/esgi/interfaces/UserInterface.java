package fr.esgi.interfaces;

import fr.esgi.model.Book;
import fr.esgi.model.Library;

public interface UserInterface {
    void referenceBook(Library library, String bookName, String authorName);
    void borrowBook(Library library, Book book);
}
