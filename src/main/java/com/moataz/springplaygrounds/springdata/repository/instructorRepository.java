package com.moataz.springplaygrounds.springdata.repository;

import com.moataz.springplaygrounds.springdata.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface instructorRepository extends JpaRepository<Instructor, Long> {

    // You can define custom query methods here
    // For example, find by last name
    List<Instructor> findByLastName(String lastName);
}