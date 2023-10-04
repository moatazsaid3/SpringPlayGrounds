package com.moataz.springplaygrounds.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

class user{
    int id;
    String firstName;
    String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public user(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
@RestController
@RequestMapping("/user")
public class HelloWorldController {

    List<user> l1 = new ArrayList<>(
            Arrays.asList(
                    new user(0, "moataz", "said"),
                    new user(1, "ahmed","salah")
            )
    );


    @RequestMapping("/hello")
    @helloWorld(value = "world", number = 0)
    public String loadPage(){
        return "hello from Spring Boot";
    }


    @RequestMapping("/goodbye")
    public String goodbye(){
        return "goodbye from Spring Boot";
    }

    // Get all users
    @GetMapping("/getUsers")
    public List<user> getUser(){
        return l1;
    }
    //create a new user
    @PostMapping("/postUser/{firstname}/{lastname}")
    public List<user> addUser(@PathVariable String firstname, @PathVariable String lastname){
        l1.add(new user(l1.size(),firstname,lastname));
        return l1;
    }
    //update a user
    @PutMapping("/updateUser/{id}/{firstname}/{lastname}")
    public List<user> updateUser(@PathVariable int id, @PathVariable String firstname, @PathVariable String lastname){
        l1.get(id).firstName = firstname;
        l1.get(id).lastName = lastname;
        return l1;
    }
    //delete a new user
    @DeleteMapping("/deleteUser/{id}")
    public List<user> deleteUser(@PathVariable int id){
        l1.remove(id);
        return l1;
    }
}
