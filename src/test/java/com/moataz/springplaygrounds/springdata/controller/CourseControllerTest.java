package com.moataz.springplaygrounds.springdata.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

import com.moataz.springplaygrounds.SpringTut.dto.User;
import com.moataz.springplaygrounds.springdata.entities.Course;
import com.moataz.springplaygrounds.springdata.entities.Instructor;
import com.moataz.springplaygrounds.springdata.entities.Student;
import com.moataz.springplaygrounds.springdata.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class CourseControllerTest {

    @Mock
    CourseService courseServiceMock;
    // AAA -> Arrange -> Action -> Assert
    @InjectMocks
    CourseController courseController = new CourseController();


    @Mock
    Instructor instructorMock; // --> Nullified instance of the Instructor class
    @Mock
    Set<Student> studentsMock ;

    @Test
    public void CourseController_getCourse_ReturnACourseById(){

        //arrange
      Course expected = new Course(
                        UUID.fromString("28028c5b-30a5-47a7-81de-65b598673df3"),
                        "math",
                        Timestamp.valueOf("2023-09-20 00:00:00"),
                        Timestamp.valueOf("2023-09-20 00:00:00"),
                        Course.CourseLevel.middle,
                        true,
                        instructorMock,
                        studentsMock
                );

        doReturn(
                new ArrayList<>(
                        Arrays.asList(
                                new Course(
                                        UUID.fromString("28028c5b-30a5-47a7-81de-65b598673df3"),
                                        "math",
                                        Timestamp.valueOf("2023-09-20 00:00:00"),
                                        Timestamp.valueOf("2023-09-20 00:00:00"),
                                        Course.CourseLevel.middle,
                                        true,
                                        instructorMock,
                                        studentsMock
                                )
                        )
                )).when(courseServiceMock).get();
        //action
        Course result = courseController.getAllCourses().get(0);

        //assert
        assertEquals(expected,result);
    }
}
