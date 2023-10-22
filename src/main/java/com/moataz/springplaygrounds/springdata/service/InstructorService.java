package com.moataz.springplaygrounds.springdata.service;

import com.moataz.springplaygrounds.springdata.dto.InstructorStudentCourseDTO;
import com.moataz.springplaygrounds.springdata.dto.UUIDDTO;
import com.moataz.springplaygrounds.springdata.entities.Instructor;
import com.moataz.springplaygrounds.springdata.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<InstructorStudentCourseDTO> getInstructorStudentCourse() {
        List<String[]> listOfInstructorStudentCourseNames = instructorRepository.getInstructorNameAndCourses();

        List<InstructorStudentCourseDTO> listOfDTO = new ArrayList<>();

        for (String[] row : listOfInstructorStudentCourseNames) {
            InstructorStudentCourseDTO instructorStudentCourseDTO = new InstructorStudentCourseDTO(row[0],row[1],row[2]);
            listOfDTO.add(instructorStudentCourseDTO);
        }
        return listOfDTO;
    }


}
