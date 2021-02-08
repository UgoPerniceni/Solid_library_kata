package fr.esgi.model;

import fr.esgi.enumeration.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;


public class UserTest {
    @Mock
    User user;

    @BeforeEach
    public void beforeTest() {
        user = new User("UserName1");
    }

    @Test
    public void testIsValiduser(){
        assertNotNull(user);
    }

    @Test
    public void testIsValidDefaultRole(){
        assertEquals(user.getRole(), Role.Guest);
    }

    @Test
    public void testIsNotValidLogin(){
        user.setLogin("NewUserName1");
        assertNotEquals(user.getLogin(), "UserName1");
    }

    @Test
    public void testIsNotValidRole(){
        user.setRole(Role.Librarian);
        assertNotEquals(user.getRole(), Role.Guest);
    }

}
