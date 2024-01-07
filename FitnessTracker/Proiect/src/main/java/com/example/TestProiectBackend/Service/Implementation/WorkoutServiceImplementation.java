package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Exercise;
import com.example.TestProiectBackend.Model.Workout;
import com.example.TestProiectBackend.Repository.ExerciseRepository;
import com.example.TestProiectBackend.Repository.WorkoutRepository;
import com.example.TestProiectBackend.Service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImplementation implements WorkoutService {
    @Autowired
    private final WorkoutRepository workoutRepository;

    //@Autowired
    //private WorkoutRepository workoutRepository;

    @Override
    public Workout findFirstByName(String name){
        return workoutRepository.findFirstByName(name);
    }

    @Override
    public void Insert(Workout workout) {
        workoutRepository.save(workout);
    }

    @Override
    public Workout ReadByName(String name) {
        Workout workout = workoutRepository.findFirstByName(name);
        return workout;
    }
}
