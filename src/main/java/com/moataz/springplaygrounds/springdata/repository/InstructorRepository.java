package com.moataz.springplaygrounds.springdata.repository;

import com.moataz.springplaygrounds.springdata.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface InstructorRepository extends JpaRepository<Instructor, UUID> {

    @Query(
            """

                  
                select i.firstName || ' ' || i.lastName as instructorName, s.firstName || ' ' || s.lastName , c.name as studentName 
                from  Instructor i 
                left join i.courses c 
                join c.students as s 
         
            """
    )
    List<String[]>  getInstructorNameAndCourses();


}