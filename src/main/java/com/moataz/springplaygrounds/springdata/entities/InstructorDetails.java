package com.moataz.springplaygrounds.springdata.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "instructor_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDetails {


    @Id
    @Column(name = "details_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "instructor_youtube_channel")
    private String youtubeChannel;
    @Column(name = "instructor_hobbies")
    private String instructorHobbies;

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


}
