package com.email.demo.service.imple;

import com.email.demo.object.User;
import com.email.demo.repository.UserRepository;
import com.email.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public List<User> getAll() {

        return repository.findAll();
    }

    @Override
    public void addUser(String userName, String password, String email, String activeCode) {

        User user = new User();
        user.setUserName(userName);
        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setUserPassword(passwordMd5);
        user.setUserActive(activeCode);
        user.setUserEmail(email);
        user.setUserStatus(0);
        repository.save(user);

    }
}
