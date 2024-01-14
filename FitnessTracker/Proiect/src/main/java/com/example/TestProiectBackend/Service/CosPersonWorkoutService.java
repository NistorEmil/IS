package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.CosPersonWorkout;
import com.example.TestProiectBackend.Model.Workout;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CosPersonWorkoutService {
    CosPersonWorkout findFirstById(Integer id);
    public void Insert(CosPersonWorkout cos);

    public List<CosPersonWorkout> getAllCosuri();

    public List<Workout> getAllWorkoutsByPersonId(Integer id);
    String deleteById(Integer id);

}