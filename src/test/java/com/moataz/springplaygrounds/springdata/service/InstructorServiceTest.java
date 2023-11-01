package com.moataz.springplaygrounds.springdata.service;

import com.moataz.springplaygrounds.springdata.customexecption.NegativeResult;
import com.moataz.springplaygrounds.springdata.dto.InstructorStudentCourseDTO;
import com.moataz.springplaygrounds.springdata.dto.UUIDDTO;
import com.moataz.springplaygrounds.springdata.entities.Instructor;
import com.moataz.springplaygrounds.springdata.repository.InstructorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

//this class will be used for writing a code example from scratch in the mocking presentation

@ExtendWith(MockitoExtension.class)
public class InstructorServiceTest {

    @Mock
    InstructorRepository instructorRepository;

    @InjectMocks
    @Spy
    InstructorService instructorService;

    //get instructor
    @Test
    public void InstructorService_getInstructorByID_ReturnInstructor() {
        //Arrange
        Instructor expectedInstructor = new Instructor(
                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
                "moataz",
                "said",
                "moatazsaid3@gmail.com",
                "011",
                null,
                null

        );
        doReturn(Optional.of(expectedInstructor)).when(instructorRepository).findById(any());
        //Action
        Instructor result = instructorService.getInstructorByID(UUID.randomUUID());


        //Assert
        assertEquals(expectedInstructor.getId(), result.getId());

    }


    //update instructor
    @Test
    public void InstructorService_updateInstructor_ReturnInstructor() {
        //Arrange
        Instructor oldInstructor = new Instructor(
                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
                "moataz",
                "said",
                "moatazsaid3@gmail.com",
                "011",
                null,
                null

        );
        Instructor newInstructor = new Instructor(
                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
                "khaled",
                "emad",
                "khaldiemad@gmail.com",
                "011",
                null,
                null

        );

        doReturn(
                Optional.of(oldInstructor)
        ).when(instructorRepository).findById(any());

        doReturn(
                newInstructor
        ).when(instructorRepository).save(newInstructor);

        //Action
        Instructor result = instructorService.update(newInstructor);
        //Assert
        assertEquals(newInstructor, result);

    }

    @Test
    public void InstructorService_CreateInstructor_ReturnCreatedInstructor(){
        //create instructor
        Instructor expectedInstructor = new Instructor(
                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
                "moataz",
                "said",
                "moatazsaid3@gmail.com",
                "011",
                null,
                null

        );

        doReturn(expectedInstructor).when(instructorRepository).save(any());

        Instructor resultInstructor =  instructorService.create(expectedInstructor);

        assertEquals(expectedInstructor, resultInstructor );

    }
    //get InstructorStu
    @Test
    public void InstructorService_getInstructorCourseStudent_ReturnStringOfInstructorStudentCourse(){
        List<InstructorStudentCourseDTO> expected = new ArrayList<>(
                Arrays.asList(
                        new InstructorStudentCourseDTO(
                                "moataz said",
                                "math",
                                "ahmed mohamed, khaled saeed"),
                        new InstructorStudentCourseDTO(
                                "ahmed saeed",
                                "math",
                                "ahmed mohamed, khaled saeed"))


        );

        doReturn(expected).when(instructorRepository).getInstructorCourseStudent();

        List<InstructorStudentCourseDTO> result = instructorService.getInstructorCourseStudent();
        assertEquals(expected,result);

    }
    //delete Instructor
//    @Test
//    public void InstructorService_DeleteInstructor_ReturnFalseWhenFindingByID() {
//        Instructor oldInstructor = new Instructor(
//                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
//                "moataz",
//                "said",
//                "moatazsaid3@gmail.com",
//                "011",
//                null,
//                null
//
//        );
//
//        doReturn(Optional.of(oldInstructor)).when(instructorRepository).delete(any());
//        doReturn(false).when(instructorRepository).deleteById(any());
//
//
//        assertThrows(NegativeResult.class, () -> {
//            instructorService.delete(new UUIDDTO(oldInstructor.getId()));
//        });
//
//
//    }
}
