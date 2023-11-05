package com.moataz.springplaygrounds.springdata.repository;

import com.moataz.springplaygrounds.springdata.entities.Instructor;
import com.moataz.springplaygrounds.springdata.entities.InstructorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface InstructorDetailRepository extends JpaRepository<InstructorDetails, UUID> {

    InstructorDetails getInstructorDetailsByInstructorId( UUID instructorID);
}
