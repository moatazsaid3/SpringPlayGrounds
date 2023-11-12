package com.moataz.springplaygrounds.springdata.service;

import com.moataz.springplaygrounds.springdata.dto.CourseInstructorDTO;
import com.moataz.springplaygrounds.springdata.entities.Course;
import com.moataz.springplaygrounds.springdata.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

    @Mock
    CourseRepository courseRepository;
    @Mock
    RedisService redisService;
    @Spy
    @InjectMocks
    CourseService courseService;

    //crud
    //create
    @Test
    public void CourseService_createCourse_ReturnCourse(){
        //AAA
        //Arrange
        CourseInstructorDTO expectedCourse = new CourseInstructorDTO(
                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
                "math",
                new Timestamp((new Date(2022,12,21,3,30,22)).getTime()),
                new Timestamp((new Date(2023,12,21,3,30,22)).getTime()),
                Course.CourseLevel.advanced,
                true,
                null
        );

        doReturn(expectedCourse.getCourse()).when(courseRepository).save(any());
        //action
        Course resultCourse = courseService.create(expectedCourse);
        //assert
        assertEquals(expectedCourse.getCourse(),resultCourse);

    }
    //read
    @Test
    public void CourseService_getCourse_ReturnCourse(){
        //AAA
        //Arrange
        CourseInstructorDTO expectedCourse = new CourseInstructorDTO(
                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
                "math",
                new Timestamp((new Date(2022,12,21,3,30,22)).getTime()),
                new Timestamp((new Date(2023,12,21,3,30,22)).getTime()),
                Course.CourseLevel.advanced,
                true,
                null
        );

        doReturn(Optional.of(expectedCourse.getCourse())).when(courseRepository).findById(any());
        //action
        Course resultCourse = courseService.getByID(expectedCourse.getId());
        //assert
        assertEquals(expectedCourse.getCourse(),resultCourse);

    }
    //update
    @Test
    public void CourseService_updateCourse_ReturnNewCourse(){
        CourseInstructorDTO oldCourse = new CourseInstructorDTO(
                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
                "math",
                new Timestamp((new Date(2022,12,21,3,30,22)).getTime()),
                new Timestamp((new Date(2023,12,21,3,30,22)).getTime()),
                Course.CourseLevel.advanced,
                true,
                null
        );
        CourseInstructorDTO expectedCourse = new CourseInstructorDTO(
                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
                "physics",
                new Timestamp((new Date(2022,12,21,3,30,22)).getTime()),
                new Timestamp((new Date(2023,12,21,3,30,22)).getTime()),
                Course.CourseLevel.middle,
                true,
                null
        );

        doReturn(Optional.of(oldCourse)).when(courseRepository).findById(any());
        doReturn(expectedCourse.getCourse()).when(courseRepository).save(any());

        Course resultCourse = courseService.update(expectedCourse);


        assertEquals(expectedCourse.getCourse(), resultCourse);
    }
    //delete
}
