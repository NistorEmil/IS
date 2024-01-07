package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.WorkoutPlan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WorkoutPlanService {
    WorkoutPlan findFirstById(Integer id);

    public void Insert(WorkoutPlan workoutPlan);

    public WorkoutPlan ReadById(Integer id);
}
