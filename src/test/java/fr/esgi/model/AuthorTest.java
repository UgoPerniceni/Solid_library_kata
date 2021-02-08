package fr.esgi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class AuthorTest {
    @Mock
    Author author;

    @BeforeEach
    public void beforeTest() {
        author = new Author("Tolkien");
    }

    @Test
    public void testIsValidAuthor(){
        assertNotNull(author);
    }

    @Test
    public void testIsNotValidName(){
        author.setName("J.R.R Tolkien");
        assertNotEquals(author.getName(), "Tolkien");
    }
}
