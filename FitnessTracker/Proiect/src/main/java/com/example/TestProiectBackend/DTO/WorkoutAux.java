package com.example.TestProiectBackend.DTO;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class WorkoutAux {

    private String name;
    private List<String> exerciseNames;
    private Integer workoutDuration;

    public String getName() {
        return name;
    }

    public List<String> getExercises() {
        return exerciseNames;
    }

    public Integer getWorkoutDuration() {
        return workoutDuration;
    }
}