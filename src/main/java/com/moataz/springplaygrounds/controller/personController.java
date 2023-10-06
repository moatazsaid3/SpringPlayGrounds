package com.moataz.springplaygrounds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import com.moataz.springplaygrounds.service.personService;

@RestController
@RequestMapping("/persons")
public class personController {
    @Autowired
    private personService personService ;
    // Get all users
    @GetMapping
    public List<Person> getPerson(){
        return personService.get();
    }
    //create a new user
    @PostMapping("/{firstName}/{lastName}")
    public List<Person> addPerson(@PathVariable String firstName, @PathVariable String lastName){
        return personService.create(firstName, lastName);
    }
    //update a user
    @PutMapping("/{id}/{firstName}/{lastName}")
    public List<Person> updatePerson(@PathVariable int id, @PathVariable String firstName, @PathVariable String lastName){

        return personService.update(id, firstName, lastName);
    }
    //delete a new user
    @DeleteMapping("/{id}")
    public List<Person> deletePerson(@PathVariable int id){
        return personService.delete(id);
    }
}
