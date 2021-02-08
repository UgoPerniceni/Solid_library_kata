package fr.esgi.interfaces;

import fr.esgi.model.Library;

public interface PersonInterface {
    void referenceBook(Library library, String bookName, String authorName);
    void borrowBook(Library library, String bookName, String authorName);
}
