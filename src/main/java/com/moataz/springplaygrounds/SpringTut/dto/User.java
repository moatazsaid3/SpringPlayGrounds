package com.moataz.springplaygrounds.SpringTut.dto;

import com.moataz.springplaygrounds.SpringTut.annotations.ValidateUser;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@ValidateUser
public class User implements Serializable {
    int id;
//    @NotBlank
    String firstName;
//    @NotBlank
    String lastName;
//    @NotNull
    int age;
//    @NotBlank
//    @Email
//    @ValidateUserEmail
    String email;


}
