package com.example.TestProiectBackend.DTO;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class WorkoutPlanAux {

    private Integer id;
    private List<String> workoutNames;
    //private List<Integer> mealIds;

    public List<String> getWorkoutNames() {
        return workoutNames;
    }

    public Integer getId() {
        return id;
    }
}