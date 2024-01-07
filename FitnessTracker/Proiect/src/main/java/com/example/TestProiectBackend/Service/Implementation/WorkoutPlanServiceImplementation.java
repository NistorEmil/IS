package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.WorkoutPlan;
import com.example.TestProiectBackend.Model.Workout;
import com.example.TestProiectBackend.Model.Exercise;
import com.example.TestProiectBackend.Model.Person;
import com.example.TestProiectBackend.Repository.WorkoutPlanRepository;
import com.example.TestProiectBackend.Repository.WorkoutRepository;
import com.example.TestProiectBackend.Service.ExerciseService;
import com.example.TestProiectBackend.Service.WorkoutPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class WorkoutPlanServiceImplementation implements WorkoutPlanService {
    private final WorkoutPlanRepository workoutPlanRepository;
    //@Autowired
    //private WorkoutPlanRepository workoutPlanRepository;

    @Override
    public WorkoutPlan findFirstById(Integer id){
        return workoutPlanRepository.findFirstById(id);
    }


    @Override
    public void Insert(WorkoutPlan workoutPlan) {
        workoutPlanRepository.save(workoutPlan);
    }

    @Override
    public WorkoutPlan ReadById(Integer id) {
        WorkoutPlan workoutPlan = workoutPlanRepository.findFirstById(id);
        return workoutPlan;
    }

}
