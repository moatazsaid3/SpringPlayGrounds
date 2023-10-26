package com.moataz.springplaygrounds.springdata.controller;

import com.moataz.springplaygrounds.SpringTut.annotations.Timed;
import com.moataz.springplaygrounds.springdata.dto.StudentDTO;
import com.moataz.springplaygrounds.springdata.dto.UUIDDTO;
import com.moataz.springplaygrounds.springdata.entities.Course;
import com.moataz.springplaygrounds.springdata.entities.Student;
import com.moataz.springplaygrounds.springdata.service.StudentService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("student")
@Log4j2
public class StudentController {

    @Autowired
    StudentService studentService;
    // Get all instructors
    @GetMapping
    public List<Student> getStudents(){
        return studentService.get();
    }
    @GetMapping("/{id}")
    public Student getStudentByID(@PathVariable String id){
        return studentService.getByID(UUID.fromString(id));
    }
    @PostMapping
    @Timed
    public Student createStudent(@RequestBody @Valid Student student){
        return studentService.create(student);
    }
    @PutMapping
    public Student updateStudent(@RequestBody  Student student){
        return studentService.update(student);
    }
    @DeleteMapping
    public void deleteStudent(@RequestBody UUIDDTO uuidDto){
        studentService.delete(uuidDto);
    }
    @GetMapping("/studentmiddle")
    public List<StudentDTO> getStudentMiddle(){
        return studentService.getStudentMiddle();
    }
}
