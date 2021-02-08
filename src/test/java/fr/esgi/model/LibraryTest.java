package fr.esgi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LibraryTest {
    @Mock
    Library library;

    @BeforeEach
    public void beforeTest() {
        List<Book> books = new ArrayList<>();
        library = new Library(books);
    }

    @Test
    public void testIsValidPerson(){
        assertNotNull(library);
    }

    @Test
    public void testHasZeroBookByDefault(){
        assertEquals(library.getBooks().size(), 0);
    }

    @Test
    public void shouldAddTwoBook(){
        library.addBook((new Book("Title", new Author("Name"))));
        library.addBook((new Book("Title2", new Author("Name2"))));
        assertEquals(library.getBooks().size(), 2);
    }
}
