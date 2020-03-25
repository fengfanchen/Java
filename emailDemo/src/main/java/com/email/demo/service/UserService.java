package com.email.demo.service;

import com.email.demo.object.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    void addUser(String userName, String password, String email, String activeCode);
}
