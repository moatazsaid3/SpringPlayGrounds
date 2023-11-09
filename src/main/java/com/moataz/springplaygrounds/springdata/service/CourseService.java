package com.moataz.springplaygrounds.springdata.service;

import com.moataz.springplaygrounds.springdata.dto.*;
import com.moataz.springplaygrounds.springdata.entities.Course;
import com.moataz.springplaygrounds.springdata.entities.Instructor;
import com.moataz.springplaygrounds.springdata.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    InstructorService instructorService;
    @Autowired
    RedisService redisService;

    public List<Course> get() {
        return courseRepository.findAll();
    }
    public Course getByID(UUID courseID) {
        var cachedCourse = redisService.getValueFromRedis(courseID.toString());
        if(cachedCourse.isPresent()){
            System.out.println("cache hit");
            return (Course) cachedCourse.get();
        }else{
            Course course = courseRepository.findById(courseID).orElse(null);
            redisService.setValueInRedis(courseID.toString(), course);
            System.out.println("cache miss");
            return course;
        }
    }

    public  Course create(CourseInstructorDTO courseInstructorDTO) {
        Course course = courseInstructorDTO.getCourse();
        if(courseInstructorDTO.getInstructor() != null){
            //get the instructor from the instructor UUID
            Instructor instructor = instructorService.getInstructorByID(courseInstructorDTO.getInstructor());
            //get the course

            //add the instructor to the course
            course.setInstructor(instructor);

            log.info(instructor);

        }
        return  courseRepository.save(course);
    }
    public Course update(CourseInstructorDTO courseInstructorDTO) {

        if(courseRepository.findById(courseInstructorDTO.getId()).isEmpty()){
            throw new EntityNotFoundException("Course with id " + courseInstructorDTO.getId() + " does not exist");
        }


        Course course = courseInstructorDTO.getCourse();

        if(courseInstructorDTO.getInstructor() != null){
            //get the instructor from the instructor UUID
            Instructor instructor = instructorService.getInstructorByID(courseInstructorDTO.getInstructor());
            //add the instructor to the course
            course.setInstructor(instructor);

        }

        return  courseRepository.save(course);
    }
    public void delete(UUIDDTO UUIDDTO) {
        courseRepository.deleteById(UUIDDTO.getId());
    }
    public List<CourseStudentDTO> getCourseNameandStudents(){

        return courseRepository.getCourseNameAndStudents();
    }
    public List<CourseStudentStartDateDTO> getCourseStudentStartDateOnLevel(){
        return courseRepository.getCourseNameStudentsOnLevel();
    }
}
