package com.moataz.springplaygrounds.springdata.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moataz.springplaygrounds.springdata.dto.StudentDTO;
import com.moataz.springplaygrounds.springdata.dto.UUIDDTO;
import com.moataz.springplaygrounds.springdata.entities.Course;
import com.moataz.springplaygrounds.springdata.entities.Student;
import com.moataz.springplaygrounds.springdata.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
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
    public Student getByID(UUID studentID) {
        return studentRepository.findById(studentID).orElse(null);
    }
    public  Student create(Student student) {
        return  studentRepository.save(student);
    }

    public Student update(Student student) {
        if(studentRepository.findById(student.getId()).isEmpty()){
            throw new EntityNotFoundException("Student with id " + student.getId() + " does not exist");
        }
        return studentRepository.save(student);
    }

    public void delete(UUIDDTO UUIDDTO) {
        if(studentRepository.findById(UUIDDTO.getId()).isEmpty()){
            throw new EntityNotFoundException("Student with id " + UUIDDTO.getId() + " does not exist");
        }
        studentRepository.deleteById(UUIDDTO.getId());
    }
   
    public List<StudentDTO> getStudentMiddle(){
        List<Student> listOfStudents = studentRepository.getStudentMedium();

        return listOfStudents.stream()
                .map(student -> objectMapper.convertValue(student, StudentDTO.class))
                .collect(Collectors.toList());

    }


}
