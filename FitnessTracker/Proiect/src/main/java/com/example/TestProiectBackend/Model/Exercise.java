package com.example.TestProiectBackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type; // muscleGrow or cardio or warmup
    private String muscleTargeted;
    private Integer repsPerSet;
    private Integer numberOfSets;
    @ManyToMany(mappedBy = "exercises")
    //@JsonManagedReference
    @JsonIgnore
    private List<Workout> workouts;
}
