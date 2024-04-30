package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    public void testGetUserById() {
        UserRepository mockRepository = mock(UserRepository.class);
        User user = new User(11, "Sami BROUKI","broukisami1@gmail.com");
        when(mockRepository.findUserById(11)).thenReturn(user);
        UserService userService = new UserService(mockRepository);
        User returnedUser  = userService.getUserById(11);
        verify(mockRepository).findUserById(11);

        // Vérifier que l'utilisateur retourné correspond à celui retourné par le mockUserRepository

        assertNotNull(returnedUser);
        assertEquals(11, returnedUser.getId());
        assertEquals("Sami BROUKI", returnedUser.getName());
        assertEquals("broukisami1@gmail.com", returnedUser.getEmail());
    }
}
