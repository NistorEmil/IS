package com.example.TestProiectBackend.DTO;

import com.example.TestProiectBackend.Model.Person;
import com.example.TestProiectBackend.Model.Workout;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class AddWorkoutToPerson {
    private Integer personId;
    private Workout workout;
    private String day;
}