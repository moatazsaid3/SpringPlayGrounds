package com.moataz.springplaygrounds.springdata.service;

import com.moataz.springplaygrounds.springdata.dto.CourseNameAndStudentsDTO;
import com.moataz.springplaygrounds.springdata.dto.CourseWithInstructorDTO;
import com.moataz.springplaygrounds.springdata.dto.UUIDDTO;
import com.moataz.springplaygrounds.springdata.entities.Course;
import com.moataz.springplaygrounds.springdata.entities.Instructor;
import com.moataz.springplaygrounds.springdata.repository.CourseRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    InstructorService instructorService;
    @Autowired
    private ModelMapper modelMapper;
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

        }
        return  courseRepository.save(course);
    }

    public Course update(CourseWithInstructorDTO courseWithInstructorDTO) {
        Course course = courseWithInstructorDTO.getCourse();
        log.info(course);
        if(courseWithInstructorDTO.getInstructor() != null){
            //get the instructor from the instructor UUID
            Instructor instructor = instructorService.getInstructorByID(courseWithInstructorDTO.getInstructor());
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

    public List<CourseNameAndStudentsDTO> getCourseNameandStudents(){
        List<Object[]> listOfCourseNameAndStudentName = courseRepository.getCourseNameAndStudentsAdvanced();
//        log.info();

        log.info();
            return listOfCourseNameAndStudentName.stream()
                    .map(employee -> modelMapper.map(employee, CourseNameAndStudentsDTO.class))
                    .collect(Collectors.toList());

//        CourseNameAndStudentsDTO  course = listOfCourseNameAndStudentName.get(0);
    }
}
