package com.moataz.springplaygrounds.springdata.service;

import com.moataz.springplaygrounds.springdata.dto.UUIDDTO;
import com.moataz.springplaygrounds.springdata.entities.Instructor;
import com.moataz.springplaygrounds.springdata.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;
    public List<Instructor> get() {

        return instructorRepository.findAll();
    }
    public Instructor getInstructorByID(UUID instructorID) {
        return instructorRepository.findById(instructorID).orElse(null);
    }
    public Instructor create(Instructor instructor) {
        return  instructorRepository.save(instructor);
    }

    public Instructor update(Instructor instructor) {
       return instructorRepository.save(instructor);
    }

    public void delete(UUIDDTO UUIDDTO) {
        instructorRepository.deleteById(UUIDDTO.getId());
    }


}
