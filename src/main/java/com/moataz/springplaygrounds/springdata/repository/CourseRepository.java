package com.moataz.springplaygrounds.springdata.repository;

import com.moataz.springplaygrounds.springdata.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {

    @Query(
            """
            SELECT c.name as courseName, s.firstName as studentName, c.startDate as startDate
            FROM Course c 
            join c.students s 
            """
    )
    List<String[]> getCourseNameAndStudents();
    @Query(
            """
            SELECT c.name as courseName, s.firstName as studentName , c.startDate as startDate
            FROM Course c 
            join c.students s 
            where c.courseLevel = 'advanced'
            """
    )
    List<String[]> getCourseNameAndStudentsAdvanced();
}
