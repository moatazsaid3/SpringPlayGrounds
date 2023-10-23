package com.moataz.springplaygrounds.springdata.service;

import com.moataz.springplaygrounds.springdata.dto.*;
import com.moataz.springplaygrounds.springdata.entities.Course;
import com.moataz.springplaygrounds.springdata.entities.Instructor;
import com.moataz.springplaygrounds.springdata.repository.CourseRepository;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    InstructorService instructorService;

    public List<Course> get() {
        return courseRepository.findAll();
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
        Course course = courseInstructorDTO.getCourse();
        log.info(course);
        if(courseInstructorDTO.getInstructor() != null){
            //get the instructor from the instructor UUID
            Instructor instructor = instructorService.getInstructorByID(courseInstructorDTO.getInstructor());
            //get the course

            //add the instructor to the course
            course.setInstructor(instructor);

            log.info(course);

        }
        return  courseRepository.save(course);
    }
    public void delete(UUIDDTO UUIDDTO) {
        courseRepository.deleteById(UUIDDTO.getId());
    }
    public List<CourseStudentDTO> getCourseNameandStudents(){
        List<String[]> listOfCourseNameAndStudentName = courseRepository.getCourseNameAndStudents();
        return getCourseStudentDTOS(listOfCourseNameAndStudentName);
    }
    public List<CourseStudentDTO> getCourseNameandStudentsAdvanced(){
        List<String[]> listOfCourseNameAndStudentName = courseRepository.getCourseNameAndStudentsAdvanced();
        return getCourseStudentDTOS(listOfCourseNameAndStudentName);
    }
    private List<CourseStudentDTO> getCourseStudentDTOS(List<String[]> listOfCourseNameAndStudentName) {
        List<CourseStudentDTO> listOfDTO = new ArrayList<>();

        for (String[] row : listOfCourseNameAndStudentName) {
            CourseStudentDTO courseStudentDTO = new CourseStudentDTO(row[0],row[1],row[2]);

            listOfDTO.add(courseStudentDTO);
        }
        return listOfDTO;
    }
}
