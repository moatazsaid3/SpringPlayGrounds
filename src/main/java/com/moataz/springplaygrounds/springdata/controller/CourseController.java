package com.moataz.springplaygrounds.springdata.controller;

import com.moataz.springplaygrounds.springdata.dto.CourseStudentDTO;
import com.moataz.springplaygrounds.springdata.dto.CourseInstructorDTO;
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
    public List<Course> getAllCourses(){
        return courseService.get();
    }
    @PostMapping
    public Course createCourse(@RequestBody CourseInstructorDTO coursDTO){
            log.info(coursDTO);
        return courseService.create(coursDTO);
    }
    @PutMapping
    public Course updateCourse(@RequestBody CourseInstructorDTO courseDTO){
        return courseService.update(courseDTO);
    }
    @DeleteMapping
    public void deleteCourse(@RequestBody UUIDDTO uuidDto){
        courseService.delete(uuidDto);
    }
    @GetMapping("/courseandstudent")
    public List<CourseStudentDTO> getCourseWithStudent(){
      return  courseService.getCourseNameandStudents();

    }
    @GetMapping("/courseandstudentAdvanced")
    public List<CourseStudentDTO> getCourseWithStudentAdvanced(){
        return  courseService.getCourseNameandStudentsAdvanced();

    }

}
