package com.moataz.springplaygrounds.springdata.service;

import com.moataz.springplaygrounds.springdata.entities.Student;
import com.moataz.springplaygrounds.springdata.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;
    @Spy
    @InjectMocks
    StudentService studentService;
    //crud
    //create
    @Test
    public void StudentService_createStudent_ReturnStudent(){
        //AAA
        //Arrange
        Student student = new Student(
                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
                "moataz",
                "said",
                12,
                Student.Gender.male,
                "moatazsaid@giza.com",
                "012",
                "21312",
                null
        );
        doReturn(student).when(studentRepository).save(any());
        //Action
        Student result = studentService.create(student);
        //Assert
        Assertions.assertEquals(student, result);

    }
    //read
    @Test
    public void StudentService_getStudentByID_ReturnStudent(){
        //AAA
        //Arrange
        Student expectedStudent = new Student(
                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
                "moataz",
                "said",
                12,
                Student.Gender.male,
                "moatazsaid@giza.com",
                "012",
                "21312",
                null
        );
        doReturn(Optional.of(expectedStudent)).when(studentRepository).findById(any());
        //Action
        Student resultStudent = studentService.getByID(expectedStudent.getId());
        //Assert
        Assertions.assertEquals(expectedStudent, resultStudent);

    }
    //update
    @Test
    public void StudentService_updateStudent_ReturnStudent(){
        //AAA
        //Arrange
        Student oldStudent = new Student(
                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
                "moataz",
                "said",
                12,
                Student.Gender.male,
                "moatazsaid@giza.com",
                "012",
                "21312",
                null
        );
        Student expectedStudent = new Student(
                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
                "ahmed",
                "khaled",
                12,
                Student.Gender.male,
                "ahmedKhaled@giza.com",
                "011",
                "21312",
                null
        );
        doReturn(
                Optional.of(oldStudent)
        ).when(studentRepository).findById(any());

        doReturn(
                expectedStudent
        ).when(studentRepository).save(any());

        //Action
        Student resultStudent = studentService.update(expectedStudent);
        //Assert
        Assertions.assertEquals(expectedStudent, resultStudent);

    }
    //delete
    @Test
    public void StudentService_deleteStudent_ReturnStudent(){
        //AAA
        //Arrange
        Student expectedStudent = new Student(
                UUID.fromString("c41fba26-1647-40a1-8076-9df3ea9ce7ec"),
                "moataz",
                "said",
                12,
                Student.Gender.male,
                "moatazsaid@giza.com",
                "012",
                "21312",
                null
        );
        doReturn(Optional.of(expectedStudent)).when(studentRepository).findById(any());
        //Action
        Student resultStudent = studentService.getByID(expectedStudent.getId());
        //Assert
        Assertions.assertEquals(expectedStudent, resultStudent);

    }

}
