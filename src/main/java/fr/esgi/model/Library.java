package fr.esgi.model;

import fr.esgi.interfaces.LibraryInterface;

import java.util.ArrayList;
import java.util.List;

public class Library implements LibraryInterface {
    private List<Book> books;

    public Library() {
        books = new ArrayList<Book>();
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void updateBooks(List<Book> books) {
        this.books = new ArrayList<>(books);
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book borrowBook(Book book) {
        books.remove(book);
        return book;
    }

    @Override
    public Book getBookByTitle(String title) {
        for(Book book: this.books){
            if(book.getTitle().equals(title)){
                return book;
            }
        }

        return null;
    }

    @Override
    public boolean contains(String bookTitle) {
        return books.contains(new Book(bookTitle, null));
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
