package com.example.springbootunittests.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public String getUser() {
        return "Tom";
    }
}
