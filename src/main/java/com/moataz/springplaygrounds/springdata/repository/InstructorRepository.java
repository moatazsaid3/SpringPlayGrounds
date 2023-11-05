package com.moataz.springplaygrounds.springdata.repository;

import com.moataz.springplaygrounds.springdata.dto.InstructorStudentCourseDTO;
import com.moataz.springplaygrounds.springdata.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface InstructorRepository extends JpaRepository<Instructor, UUID> {

    @Query(
            """
                select new com.moataz.springplaygrounds.springdata.dto.InstructorStudentCourseDTO(i.firstName || ' ' || i.lastName, c.name , LISTAGG(s.firstName || ' ' || s.lastName, ', ') WITHIN GROUP (ORDER BY (s.firstName)) ) as studentName 
                from  Instructor i 
                join i.courses c 
                join c.students as s 
                GROUP BY i.firstName || ' ' || i.lastName, c.name
            """
    )
    List<InstructorStudentCourseDTO>  getInstructorCourseStudent();


    Instructor getInstructorByPhoneNumber(String phoneNumber);
}