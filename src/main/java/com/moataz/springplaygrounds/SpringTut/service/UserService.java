package com.moataz.springplaygrounds.SpringTut.service;

import com.moataz.springplaygrounds.SpringTut.validators.UserValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.moataz.springplaygrounds.SpringTut.dto.User;

@Service
@Log4j2
public class UserService  {

    UserValidator userValidator = new UserValidator();
    List<User> users = new ArrayList<User>(
            Arrays.asList(
                    new User(
                            2,
                            "Ahmed",
                            "said",
                            34,
                            "Ahmedsaid3@gmail.com"
                    ),
                    new User(
                            1,
                            "moataz",
                            "said",
                            24,
                            "moatazsaid3@gmail.com"
                    )

            )
    );

    public List<User> getAllUser() throws Exception { //when its executed -> perform the method and return the mock // when its not executed return mock
        return users;
    }
    public User getUser(int id)  {
        return users.get(id);
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
    public int numberOfUsers(){


        return  countUsers(users);
    }
    public int countUsers(List<User> list){
        return  list.size();
    }//stub -> return 3
}
