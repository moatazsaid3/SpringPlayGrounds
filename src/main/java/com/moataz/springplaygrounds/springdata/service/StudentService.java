package com.moataz.springplaygrounds.springdata.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moataz.springplaygrounds.springdata.dto.StudentDTO;
import com.moataz.springplaygrounds.springdata.dto.UUIDDTO;
import com.moataz.springplaygrounds.springdata.entities.Course;
import com.moataz.springplaygrounds.springdata.entities.Student;
import com.moataz.springplaygrounds.springdata.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ObjectMapper objectMapper;

    public List<Student> get() {

        return studentRepository.findAll();
    }
    public  Student create(Student student) {
        return  studentRepository.save(student);
    }

    public Student update(Student student) {
        return studentRepository.save(student);
    }

    public void delete(UUIDDTO UUIDDTO) {
        studentRepository.deleteById(UUIDDTO.getId());
    }
    public void addCourses(Student student, Course course){

    }
    public List<StudentDTO> getStudentMiddle(){
        List<Student> listOfStudents = studentRepository.getStudentMedium();

        return listOfStudents.stream()
                .map(student -> objectMapper.convertValue(student, StudentDTO.class))
                .collect(Collectors.toList());

    }
}
