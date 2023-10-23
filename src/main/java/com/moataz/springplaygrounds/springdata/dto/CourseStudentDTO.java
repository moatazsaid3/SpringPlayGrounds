package com.moataz.springplaygrounds.springdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudentDTO {
    String courseName;
    String startDate;
    String studentName;

}
