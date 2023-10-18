package com.moataz.springplaygrounds.springdata.controller;

import com.moataz.springplaygrounds.springdata.dto.CourseNameAndStudentsDTO;
import com.moataz.springplaygrounds.springdata.dto.CourseWithInstructorDTO;
import com.moataz.springplaygrounds.springdata.dto.UUIDDTO;
import com.moataz.springplaygrounds.springdata.entities.Course;
import com.moataz.springplaygrounds.springdata.service.CourseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("course")
@Log4j2
public class CourseController {

    @Autowired
    CourseService courseService;
    @GetMapping
    public List<Course> getCourse(){
        return courseService.get();
    }
    @PostMapping
    public Course createCourse(@RequestBody CourseWithInstructorDTO coursDTO){
            log.info(coursDTO);
        return courseService.create(coursDTO);
    }
    @PutMapping
    public Course updateCourse(@RequestBody CourseWithInstructorDTO courseDTO){
        return courseService.update(courseDTO);
    }
    @DeleteMapping
    public void deleteCourse(@RequestBody UUIDDTO uuidDto){
        courseService.delete(uuidDto);
    }
    @GetMapping("/courseandstudent")
    public List<CourseNameAndStudentsDTO> getCourseWithStudent(){
      return  courseService.getCourseNameandStudents();

    }

}
