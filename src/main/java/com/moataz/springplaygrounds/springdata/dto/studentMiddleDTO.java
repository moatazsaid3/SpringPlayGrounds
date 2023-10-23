package com.moataz.springplaygrounds.springdata.dto;

import com.moataz.springplaygrounds.springdata.entities.Course;
import com.moataz.springplaygrounds.springdata.entities.Student;
import lombok.Data;

@Data
public class studentMiddleDTO {
    Student student;
    Course.CourseLevel courseLevel;
}
