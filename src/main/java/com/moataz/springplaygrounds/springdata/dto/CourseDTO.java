package com.moataz.springplaygrounds.springdata.dto;

import com.moataz.springplaygrounds.springdata.entities.Course;
import com.moataz.springplaygrounds.springdata.entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
public class CourseDTO {
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;
    private Course.CourseLevel courseLevel;
    private boolean isStarted;
    private Instructor instructor;

}
