package com.moataz.springplaygrounds.springdata.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    // Declare the enum type for gender
    public enum Gender {
        male, female;
    }
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "student_first_name")
    private String firstName;
    @Column(name = "student_last_name")
    private String lastName;
    @Column(name = "student_age")
    private int age;
    @Column(name = "student_gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "student_email")
    private String email;
    @Column(name = "student_phone_number")
    private String phoneNumber;
    @Column(name = "student_nat_id")
    private String natID;

    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    private Set<Course> Courses;

}
