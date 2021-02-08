package fr.esgi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserListTest {
    @Mock
    UserList userList;

    @BeforeEach
    public void beforeTest() {
        List<User> users = new ArrayList<>();
        userList = new UserList();
        userList.updateUsers(users);
    }

    @Test
    public void testIsValidPerson(){
        assertNotNull(userList);
    }

    @Test
    public void testHasZeroBookByDefault(){
        assertEquals(userList.getUsers().size(), 0);
    }

    @Test
    public void shouldAddTwoBook(){
        userList.addNewUser((new User("Login")));
        userList.addNewUser((new User("Login2")));
        assertEquals(userList.getUsers().size(), 2);
    }
}
