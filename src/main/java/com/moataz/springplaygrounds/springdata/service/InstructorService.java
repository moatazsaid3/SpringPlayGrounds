package com.moataz.springplaygrounds.springdata.service;

import com.moataz.springplaygrounds.springdata.dto.InstructorStudentCourseDTO;
import com.moataz.springplaygrounds.springdata.dto.UUIDDTO;
import com.moataz.springplaygrounds.springdata.entities.Instructor;
import com.moataz.springplaygrounds.springdata.repository.InstructorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;
    @Autowired
    InstructorValidatorService instructorValidatorService;

    protected  boolean validateEmail(Instructor instructor){
        System.out.println("helllo");
        return instructorValidatorService.validateEmail(instructor);
    }
    protected  boolean validatePhoneNumber(Instructor instructor){
        return instructorValidatorService.validatePhoneNumber(instructor);
    }
    protected  boolean validateYoutubeChannel(Instructor instructor){
        return instructorValidatorService.validateYoutubeChannel(instructor);
    }

    public List<Instructor> get() {

        return instructorRepository.findAll();
    }
    public Instructor getInstructorByID(UUID instructorID) {
        return instructorRepository.findById(instructorID).orElse(null);
    }
    public Instructor create(Instructor instructor) throws Exception {
        if(!validateEmail(instructor)){
            return null;
        }
        if(!validatePhoneNumber(instructor)){
            throw new Exception("phone number already exists");
        }
//        if(!validateYoutubeChannel(instructor)){
//            return null;
//        }

        return  instructorRepository.save(instructor);
    }

    public Instructor update(Instructor instructor) {
        if(instructorRepository.findById(instructor.getId()).isEmpty()){
            throw new EntityNotFoundException("Instructor with id " + instructor.getId() + " does not exist");
        }
       return instructorRepository.save(instructor);
    }

    public void delete(UUIDDTO UUIDDTO) {
        if(instructorRepository.findById(UUIDDTO.getId()).isEmpty()){
            throw new EntityNotFoundException("Instructor with id " + UUIDDTO.getId() + " does not exist");
        }
        instructorRepository.deleteById(UUIDDTO.getId());

    }

    public List<InstructorStudentCourseDTO> getInstructorCourseStudent() {
        return instructorRepository.getInstructorCourseStudent();
    }


}
