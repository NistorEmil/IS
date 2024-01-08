package com.example.TestProiectBackend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties("exercises")
public class Workout {
    @Id
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinTable(
            name = "workout_exercise",
            joinColumns = @JoinColumn(name = "workout_name"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    @JsonIgnore
    private List<Exercise> exercises;
    private Integer workoutDuration;
    private String day;
    @OneToMany
    private List<CosPersonWorkout> cosPersonWorkouts;

    @Override
    public String toString() {
        return "Workout{" +
                "name='" + name + '\'' +
                ", workoutDuration=" + workoutDuration +
                ", day='" + day + '\'' +
                '}';
    }

    public Workout(String name, List<Exercise> exercises, Integer workoutDuration, String day) {
        this.name = name;
        this.exercises = exercises;
        this.workoutDuration = workoutDuration;
        this.day = day;
    }
}
