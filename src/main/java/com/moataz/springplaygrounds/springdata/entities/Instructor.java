package com.moataz.springplaygrounds.springdata.entities;

import jakarta.persistence.*;
import lombok.Data;

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

    @OneToMany(mappedBy="instructor",fetch = FetchType.EAGER)
    private Set<Course> courses;

    @OneToOne(mappedBy = "instructor", fetch = FetchType.EAGER)
    private InstructorDetails details;

}
