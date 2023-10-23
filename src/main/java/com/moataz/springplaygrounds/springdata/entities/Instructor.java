package com.moataz.springplaygrounds.springdata.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "instructor")
@Data
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy="instructor")
    private Set<Course> courses;

    @OneToOne(mappedBy = "instructor")
    private InstructorDetails details;

}
