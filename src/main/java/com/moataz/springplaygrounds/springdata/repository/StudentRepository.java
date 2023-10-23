package com.moataz.springplaygrounds.springdata.repository;

import com.moataz.springplaygrounds.springdata.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    @Query(
            """   
            SELECT c.students
            FROM Course c
            where c.courseLevel = 'middle'
         
            """
    )
    List<Student> getStudentMedium();

}
