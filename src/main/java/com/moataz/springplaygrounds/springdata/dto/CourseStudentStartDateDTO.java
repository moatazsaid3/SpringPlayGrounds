package com.moataz.springplaygrounds.springdata.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Timestamp;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudentStartDateDTO {
    private String courseName;
    private String studentNames;
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Timestamp startDate;
}
