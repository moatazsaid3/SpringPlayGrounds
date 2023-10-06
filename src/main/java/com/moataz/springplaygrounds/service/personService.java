package com.moataz.springplaygrounds.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.moataz.springplaygrounds.controller.Person ;
@Service
public class personService {

    List<Person> l1 = new ArrayList<>(
            Arrays.asList(
                    new Person(0, "moataz", "said"),
                    new Person(1, "ahmed","salah")
            )
    );

    public List<Person> get() {
        return l1;
    }
    public List<Person> create(String firstName, String lastName) {
        l1.add(new Person(l1.size(),firstName, lastName));
        return l1;
    }

    public List<Person> update(int id, String firstName, String lastName) {
        l1.get(id).setFirstName(firstName);
        l1.get(id).setLastName(lastName);
        return l1;
    }

    public List<Person> delete(int id) {
        l1.remove(id);
        return l1;
    }


}
