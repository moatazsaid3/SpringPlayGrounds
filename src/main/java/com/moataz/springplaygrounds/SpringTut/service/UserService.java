package com.moataz.springplaygrounds.SpringTut.service;

import com.moataz.springplaygrounds.SpringTut.validators.UserValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.moataz.springplaygrounds.SpringTut.dto.User;

@Service
@Log4j2
public class UserService {

    UserValidator userValidator = new UserValidator();

    List<User> users = new ArrayList<>();

    public List<User> get() {
        return users;
    }
    public List<User> create(User user) {
        users.add(user);
        return users;
    }

    public List<User> update(User user) {
        users.get(user.getId()).setFirstName(user.getFirstName());
        users.get(user.getId()).setLastName(user.getLastName());
        users.get(user.getId()).setAge(user.getAge());
        users.get(user.getId()).setEmail(user.getEmail());
        return users;
    }

    public List<User> delete(int id) {
        users.remove(id);
        return users;
    }
}
