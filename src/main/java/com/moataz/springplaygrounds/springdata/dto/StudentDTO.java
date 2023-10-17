package com.moataz.springplaygrounds.springdata.dto;

import com.moataz.springplaygrounds.springdata.entities.Course;
import com.moataz.springplaygrounds.springdata.entities.Student;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;
@Data
public class StudentDTO {

    private String firstName;
    private String lastName;
    private int age;
    private Student.Gender gender;
    private String email;
    private String phoneNumber;
    private String natID;
    private Set<Course> Courses;

}
