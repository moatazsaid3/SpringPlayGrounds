package com.moataz.springplaygrounds.springdata.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.moataz.springplaygrounds.springdata.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseInstructorDTO {
    private UUID id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Timestamp startDate;
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Timestamp endDate;
    private Course.CourseLevel courseLevel;
    private boolean isStarted;
    private UUID instructor;

    public Course getCourse(){

        Course course = new Course();
        course.setId(this.id);
        course.setName(this.name);
        course.setStartDate(this.startDate);
        course.setEndDate(this.endDate);
        course.setCourseLevel(this.courseLevel);
        course.setStarted(this.isStarted);

        return course;
    }
}
