package com.moataz.springplaygrounds.springdata.dto;

import com.moataz.springplaygrounds.springdata.entities.Course;
import lombok.Data;
import lombok.Getter;

@Data
public class CourseLevelDTO {
    private Course.CourseLevel courseLevel;
}
