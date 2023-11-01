package com.moataz.springplaygrounds.springdata.controller;

import com.moataz.springplaygrounds.SpringTut.annotations.Timed;
import com.moataz.springplaygrounds.springdata.dto.InstructorStudentCourseDTO;
import com.moataz.springplaygrounds.springdata.dto.UUIDDTO;
import com.moataz.springplaygrounds.springdata.entities.Instructor;
import com.moataz.springplaygrounds.springdata.service.InstructorService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("instructor")
@Log4j2
public class InstructorController {


   @Autowired
    InstructorService instructorService;
    // Get all instructors
    @GetMapping
    public List<Instructor> getInstructors(){
            return  instructorService.get();
    }
    @GetMapping("/{id}")
    public Instructor getInstructorByID( @PathVariable String id){
        return instructorService.getInstructorByID(UUID.fromString(id));
    }
    //create a new instructor
    @PostMapping
    @Timed
    public Instructor createInstructor(@RequestBody @Valid Instructor instructor){
        log.info(instructor);
        return instructorService.create(instructor);
    }
    //update a instructors
    @PutMapping
    public Instructor updateInstructor(@RequestBody  Instructor instructor){
        return instructorService.update(instructor);
    }
    //delete a new user
    @DeleteMapping
    public void deleteInstructor(@RequestBody UUIDDTO uuidDTO){
         instructorService.delete(uuidDTO);
    }
    @GetMapping("/instructorcoursestudent")
    public List<InstructorStudentCourseDTO> getInstructorCourseStudent(){
        return instructorService.getInstructorCourseStudent();
    }
}
