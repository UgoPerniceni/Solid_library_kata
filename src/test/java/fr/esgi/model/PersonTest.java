package fr.esgi.model;

import fr.esgi.enumeration.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;


public class PersonTest {
    @Mock
    Person person;

    @BeforeEach
    public void beforeTest() {
        person = new Person("UserName1");
    }

    @Test
    public void testIsValidPerson(){
        assertNotNull(person);
    }

    @Test
    public void testIsValidDefaultRole(){
        assertEquals(person.getRole(), Role.Guest);
    }

    @Test
    public void testIsNotValidLogin(){
        person.setLogin("NewUserName1");
        assertNotEquals(person.getLogin(), "UserName1");
    }

    @Test
    public void testIsNotValidRole(){
        person.setRole(Role.Librarian);
        assertNotEquals(person.getRole(), Role.Guest);
    }

}
