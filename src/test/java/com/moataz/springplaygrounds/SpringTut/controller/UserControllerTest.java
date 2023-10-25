package com.moataz.springplaygrounds.SpringTut.controller;

import com.moataz.springplaygrounds.SpringTut.dto.User;
import com.moataz.springplaygrounds.SpringTut.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    UserService userService;
    @InjectMocks
    UserController userController = new UserController();
    @Test
    public void UserController_getUser_ReturnAUser(){
        //Arrange
        User expected =
                new User(
                        1,
                        "moataz",
                        "said",
                        24,
                        "moatazsaid3@gmail.com"
                );
//        UserService userService1 = mock(UserService.class);

        doReturn(
                new ArrayList<>(
                            Arrays.asList(
                                    new User(
                                            1,
                                            "moataz",
                                            "said",
                                            24,
                                            "moatazsaid3@gmail.com"
                                    )
                            )
                )).when(userService).get();
        //Action
        User result = userController.getUser().get(0);


        //Assert
        assertEquals(expected, result);

    }

//    @Test
//    public void UserController_getNumberOfUsers_ReturnNumberOfUsers(){
//        //Arrange
//        int expected = 3;
//        doReturn(3).when(userService).countUsers(any());
//        //Action
//        int result = userController.numberOfUsers();
//
//
//        //Assert
//        assertEquals(expected, result);
//
//    }


}
