package com.moataz.springplaygrounds.springdata.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "instructor_details")
@Data
public class InstructorDetails {


    @Id
    @Column(name = "details_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "instructor_youtube_channel")
    private String youtubeChannel;
    @Column(name = "instructor_hobbies")
    private String instructorHobbies;

    @OneToOne()
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


}
