package com.moataz.springplaygrounds.springdata.service;

import com.moataz.springplaygrounds.springdata.entities.Instructor;
import com.moataz.springplaygrounds.springdata.entities.InstructorDetails;
import com.moataz.springplaygrounds.springdata.repository.InstructorDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InstructorDetailsService {

    @Autowired
    InstructorDetailRepository instructorDetailRepository;

    public void addDetails(InstructorDetails instructorDetails){

        instructorDetailRepository.save(instructorDetails);
    }
    public InstructorDetails getDetail(String instructoID){
       return instructorDetailRepository.getInstructorDetailsByInstructorId(UUID.fromString("e7cccf78-5506-43d1-862e-d93b4dc82dd5"));
    }
}
