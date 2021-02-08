package fr.esgi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class BookTest {
    @Mock
    Book book;

    @BeforeEach
    public void beforeTest() {
        Author author = new Author("Tolkien");
        book = new Book("Lord of the ring", author);
    }

    @Test
    public void testIsValidBook(){
        assertNotNull(book);
    }

    @Test
    public void testIsNotValidTitle(){
        book.setTitle("Lord of the ring 4");
        assertNotEquals(book.getTitle(), "Lord of the ring");
    }
}
