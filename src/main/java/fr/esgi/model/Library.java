package fr.esgi.model;

import fr.esgi.interfaces.LibraryInterface;

import java.util.List;

public class Library implements LibraryInterface {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book seeBook(Book book) {
        return book;
    }

    @Override
    public Boolean borrowBook(Book book) {
        if(books.contains(book)){
            books.remove(book);
            return true;
        }

        return false;
    }
}
