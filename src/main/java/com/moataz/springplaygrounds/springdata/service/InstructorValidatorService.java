package com.moataz.springplaygrounds.springdata.service;

import com.moataz.springplaygrounds.springdata.entities.Instructor;
import com.moataz.springplaygrounds.springdata.entities.InstructorDetails;
import com.moataz.springplaygrounds.springdata.repository.InstructorDetailRepository;
import com.moataz.springplaygrounds.springdata.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class InstructorValidatorService  {

   @Autowired
   InstructorDetailRepository instructorDetailRepository;
   @Autowired
   InstructorRepository instructorRepository;


   public boolean validateEmail(Instructor instructor){

      String email = instructor.getEmail();
      if (email != null && !email.isEmpty()) {
         // Define a regex pattern for email
         // You can modify it according to your requirements
         String pattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
         // Check if the email matches the pattern
         if (!email.matches(pattern)) {
            // Reject the email field with an error code and message
//            errors.rejectValue("email", "email.invalid", "Email is invalid");
            return false;
         }
      }
      return true;

   }
   //1-  check if the phone number exists in the database (if exists --> return false)
   //2-  validate phone number (if its not valid --> return false)
   //3-  return true
   public boolean validatePhoneNumber(Instructor instructor){
      System.out.println("Hello");
      String phoneNumber = instructor.getPhoneNumber();
      //check if the phone number already exists
      if(instructorRepository.getInstructorByPhoneNumber(phoneNumber) != null){ // if it is not null then an instructor already has this phone number
         return false;
      }


      if (phoneNumber != null && !phoneNumber.isEmpty()) {
         String pattern = "^\\+?[0-9]{10,15}$";
         if (!phoneNumber.matches(pattern)) {
            return false;
         }
      }
      return true;
   }
   public boolean validateYoutubeChannel(Instructor instructor){


      InstructorDetails insDeats = instructorDetailRepository.getInstructorDetailsByInstructorId(instructor.getId());
      if(insDeats == null){
         return false;
      }
      String youtubeChannel = insDeats.getYoutubeChannel();
      System.out.println(youtubeChannel);
      if (youtubeChannel == null || youtubeChannel.isEmpty()) {
        return false;
      }
      return true;
   }


}
