package com.moataz.springplaygrounds.SpringTut.controller;

import com.moataz.springplaygrounds.SpringTut.annotations.Timed;
import com.moataz.springplaygrounds.SpringTut.dto.User;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import com.moataz.springplaygrounds.SpringTut.service.UserService;

@RestController
@RequestMapping("/users") // http://localhost:3000/persons
@Log4j2
public class UserController {
    @Autowired
    private UserService userService;
    // Get all users
    @GetMapping
    public List<User> getUser(){
        return userService.get();
    }

    //create a new user
    @PostMapping("")
    @Timed
    public List<User> createUser(@RequestBody @Valid User user){
        log.info(user);
        return userService.create(user);
    }
    //update a user
    @PutMapping("")
    public List<User> updateUser(@RequestBody  User user){
        return userService.update(user);
    }
    //delete a new user
    @DeleteMapping("/{id}")
    public List<User> deleteUser(@PathVariable int id){
        return userService.delete(id);
    }
    @GetMapping("/numberofUsers")
    public int numberOfUsers(){
        return userService.numberOfUsers();
    }
}
