package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.Workout;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WorkoutService {
    Workout findFirstByName(String name);

    public void Insert(Workout workout);

    public Workout ReadByName(String name);
}
