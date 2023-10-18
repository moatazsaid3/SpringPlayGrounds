package com.moataz.springplaygrounds.springdata.repository;

import com.moataz.springplaygrounds.springdata.dto.CourseDTO;
import com.moataz.springplaygrounds.springdata.dto.CourseNameAndStudentsDTO;
import com.moataz.springplaygrounds.springdata.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {

    @Query(
            """
            SELECT c.name as courseName, s.firstName as studentName
            FROM Course c 
            join c.students s 
            """
    )
    List<Object[]> getCourseNameAndStudentsAdvanced();
//    [[math,david],[physics,atef]]
}
