package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.Breakfast;
import com.example.TestProiectBackend.Model.Workout;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WorkoutService {
    Workout findFirstByName(String name);

    public String Insert(Workout workout);

    public Workout ReadByName(String name);
    public String Save(Workout workout);
    public String Delete(Workout workout);
}
