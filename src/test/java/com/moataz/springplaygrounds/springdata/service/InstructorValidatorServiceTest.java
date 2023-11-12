package com.moataz.springplaygrounds.springdata.service;

import com.moataz.springplaygrounds.springdata.entities.Instructor;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import com.moataz.springplaygrounds.springdata.entities.InstructorDetails;
import com.moataz.springplaygrounds.springdata.repository.InstructorDetailRepository;
import com.moataz.springplaygrounds.springdata.repository.InstructorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class InstructorValidatorServiceTest {
    @Mock
    InstructorRepository instructorRepository;
    @Mock
    RedisService redisService;
    @Mock
    InstructorDetailRepository instructorDetailRepository;
    @InjectMocks
    @Spy
    InstructorValidatorService instructorValidatorService;


    @Test
    public void InstructorValidatorService_validateEmail_ReturnTrue(){
        Instructor instructor = new Instructor(
                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
                "moataz",
                "said",
                "moatazsaid3@gmail.com",
                "01142381453",
                null,
                null

        );
        assertTrue(instructorValidatorService.validateEmail(instructor));
    }

    @Test
    public void InstructorValidatorService_validatePhoneNumber_ReturnTrue(){
        Instructor instructor = new Instructor(
                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
                "moataz",
                "said",
                "moatazsaid3@gmail.com",
                "01142381453",
                null,
                null

        );
        doReturn(
                    null
                ).when(instructorRepository).getInstructorByPhoneNumber(any());


        assertTrue(instructorValidatorService.validatePhoneNumber(instructor));
    }

    @Test
    public void InstructorValidatorService_validateYoutubeChannel_ReturnTrue(){
        Instructor instructor = new Instructor(
                UUID.fromString("e7cccf78-5506-43d1-862e-d93b4dc82dd5"),
                "mohamed",
                 "said",
                 "mohamedsaid@giza.com",
                 "01243981032",
                 null,
                new InstructorDetails(
                        UUID.fromString("46521237-b69e-47ff-8018-cdf6d820eed3"),
                        "https://www.youtube.com/mohamedsaid",
                        "swimming",
                        null)
                );
        doReturn(
                instructor.getDetails()
                ).when(instructorDetailRepository).getInstructorDetailsByInstructorId(any());

        assertTrue(instructorValidatorService.validateYoutubeChannel(instructor));
    }
}
