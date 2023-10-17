package com.moataz.springplaygrounds.springdata.controller;

import com.moataz.springplaygrounds.SpringTut.annotations.Timed;
import com.moataz.springplaygrounds.springdata.dto.UUIDDTO;
import com.moataz.springplaygrounds.springdata.entities.Student;
import com.moataz.springplaygrounds.springdata.service.StudentService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
@Log4j2
public class StudentController {

    @Autowired
    StudentService studentService;
    // Get all instructors
    @GetMapping
    public List<Student> getInstructors(){
        return studentService.get();
    }
    @PostMapping
    @Timed
    public Student createInstructor(@RequestBody @Valid Student student){
        log.info(student);
        return studentService.create(student);
    }
    @PutMapping
    public Student updateInstructor(@RequestBody  Student student){
        return studentService.update(student);
    }
    @DeleteMapping
    public void deleteInstructor(@RequestBody UUIDDTO uuidDto){
        studentService.delete(uuidDto);
    }
}
