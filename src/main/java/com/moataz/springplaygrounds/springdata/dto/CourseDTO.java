package com.moataz.springplaygrounds.springdata.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.moataz.springplaygrounds.springdata.entities.Course;
import com.moataz.springplaygrounds.springdata.entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CourseDTO {
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Timestamp startDate;
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Timestamp endDate;
    private Course.CourseLevel courseLevel;
    private boolean isStarted;
    private Instructor instructor;

}
