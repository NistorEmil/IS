package com.example.TestProiectBackend.DTO;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class AddWorkoutToPerson {
    private Integer personId;
    private String workoutName;
    private String day;
}