package com.moataz.springplaygrounds.springdata.repository;


import com.moataz.springplaygrounds.springdata.dto.CourseStudentDTO;
import com.moataz.springplaygrounds.springdata.dto.CourseStudentStartDateDTO;
import com.moataz.springplaygrounds.springdata.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {

    @Query(
            """
            SELECT new com.moataz.springplaygrounds.springdata.dto.CourseStudentDTO(c.name,LISTAGG(s.firstName || ' ' || s.lastName, ', ') WITHIN GROUP (ORDER BY (s.firstName))) 
            FROM Course c 
            join c.students s
            GROUP BY c.name
            """
    )
    List<CourseStudentDTO> getCourseNameAndStudents();


    //LISTAGG(s.firstName || ' ' || s.lastName, ', ') WITHIN GROUP (ORDER BY (s.firstName))
    //array_agg (s.firstName || ' ' || s.lastName)
    @Query (
                """
                SELECT 
                new com.moataz.springplaygrounds.springdata.dto.CourseStudentStartDateDTO (c.name,LISTAGG(s.firstName || ' ' || s.lastName, ', ') WITHIN GROUP (ORDER BY (s.firstName)), c.startDate) 
                FROM Course c 
                JOIN c.students s
                WHERE c.courseLevel = 'beginner'
                GROUP BY c.name, c.startDate 
                """
    )
    public List<CourseStudentStartDateDTO> getCourseNameStudentsOnLevel ();
}