package com.moataz.springplaygrounds.SpringTut.dto;

import com.moataz.springplaygrounds.SpringTut.annotations.ValidateUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@ValidateUser
@RedisHash("User")
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
