package com.example.springbootunittests.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void  testGetUser() {
        assertEquals(userService.getUser(), "Tom");
    }
}