package com.moataz.springplaygrounds.springdata.dto;

import com.moataz.springplaygrounds.springdata.entities.Course;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class CourseWithInstructorDTO {
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;
    private Course.CourseLevel courseLevel;
    private boolean isStarted;
    private UUID instructor;

    public Course getCourse(){
        Course course  =  new Course();
        course.setName(this.name);
        course.setStartDate(this.startDate);
        course.setEndDate(this.endDate);
        course.setCourseLevel(this.courseLevel);
        course.setStarted(this.isStarted);

        return course;
    }
}
