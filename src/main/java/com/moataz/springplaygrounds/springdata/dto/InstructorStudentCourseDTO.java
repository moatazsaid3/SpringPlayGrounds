package com.moataz.springplaygrounds.springdata.dto;

import lombok.*;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class InstructorStudentCourseDTO {
    String instructorName;
    String courseName;
    String studentName;
}
