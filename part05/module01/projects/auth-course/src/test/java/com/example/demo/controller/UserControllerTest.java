package com.example.demo.controller;

import com.example.demo.controllers.UserController;
import com.example.demo.model.persistence.User;
import com.example.demo.model.persistence.repositories.CartRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import com.example.demo.model.requests.CreateUserRequest;
import com.example.demo.util.InjectDependencies;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserControllerTest {
    private UserController userController;

    private UserRepository userRepository = mock(UserRepository.class);

    private CartRepository cartRepository = mock(CartRepository.class);

    private BCryptPasswordEncoder bCryptPasswordEncoder = mock(BCryptPasswordEncoder.class);

    @Before
    public void setUp() {
        userController = new UserController();
        InjectDependencies.injectObjects(userController, "userRepository", userRepository);
        InjectDependencies.injectObjects(userController, "cartRepository", cartRepository);
        InjectDependencies.injectObjects(userController, "bCryptPasswordEncoder", bCryptPasswordEncoder);
    }

    @Test
    public void shouldCreateUser() {
        // given
        final String username = "usertest";
        final String password = "testpasswd";
        final String confirmPassword = "testpasswd";
        when(bCryptPasswordEncoder.encode(password)).thenReturn("hashedPassword");

        // when
        final ResponseEntity<User> response = createUser(username, password, confirmPassword);

        // then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        final User userResponse = response.getBody();
        assertNotNull(userResponse);
        assertEquals(0, userResponse.getId());
        assertEquals("usertest", userResponse.getUsername());
        assertEquals("hashedPassword", userResponse.getPassword());
    }

    @Test
    public void shouldFindUserByUsername() {
        // given
        final String username = "usertest";
        final String password = "testpasswd";
        final String confirmPassword = "testpasswd";
        when(bCryptPasswordEncoder.encode(password)).thenReturn("hashedPassword");

        final ResponseEntity<User> createdUser = createUser(username, password, confirmPassword);

        // when
        when(userRepository.findByUsername(username)).thenReturn(createdUser.getBody());
        final ResponseEntity<User> response = userController.findByUserName(username);

        // then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        final User userResponse = response.getBody();
        final User createdUserResponse = createdUser.getBody();
        assertEquals(createdUserResponse.getId(), userResponse.getId());
        assertEquals(createdUserResponse.getUsername(), userResponse.getUsername());
    }


    public ResponseEntity<User> createUser(String username, String password, String confirmPassword) {
        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setUsername(username);
        userRequest.setPassword(password);
        userRequest.setConfirmPassword(confirmPassword);

        return userController.createUser(userRequest);
    }
}
