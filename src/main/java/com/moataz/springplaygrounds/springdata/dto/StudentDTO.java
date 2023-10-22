package com.moataz.springplaygrounds.springdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.moataz.springplaygrounds.springdata.entities.Course;
import com.moataz.springplaygrounds.springdata.entities.Student;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private Student.Gender gender;
    private String email;
    private String phoneNumber;
    private String natID;
    private Set<Course> Courses;

}
