package com.moataz.springplaygrounds.springdata.service;

import com.moataz.springplaygrounds.springdata.dto.CourseNameAndStudentsDTO;
import com.moataz.springplaygrounds.springdata.dto.CourseWithInstructorDTO;
import com.moataz.springplaygrounds.springdata.dto.UUIDDTO;
import com.moataz.springplaygrounds.springdata.entities.Course;
import com.moataz.springplaygrounds.springdata.entities.Instructor;
import com.moataz.springplaygrounds.springdata.repository.CourseRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public  Course create(CourseWithInstructorDTO courseWithInstructorDTO) {
        Course course = courseWithInstructorDTO.getCourse();
        if(courseWithInstructorDTO.getInstructor() != null){
            //get the instructor from the instructor UUID
            Instructor instructor = instructorService.getInstructorByID(courseWithInstructorDTO.getInstructor());
            //get the course

            //add the instructor to the course
            course.setInstructor(instructor);

            log.info(instructor);


            return  courseRepository.save(course);
        }else{
            return courseRepository.save(course);
        }
    }

    public Course update(Course course) {
        return courseRepository.save(course);
    }

    public void delete(UUIDDTO UUIDDTO) {
        courseRepository.deleteById(UUIDDTO.getId());
    }

    public void getCourseNameandStudents(){
        log.info(courseRepository.getCourseNameAndStudentsAdvanced());
    }
}
