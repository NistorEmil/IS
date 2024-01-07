package com.example.TestProiectBackend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class WorkoutPlan {
    @Id
    private Integer id;
    @OneToMany
    private List<Workout> workouts;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }
}
