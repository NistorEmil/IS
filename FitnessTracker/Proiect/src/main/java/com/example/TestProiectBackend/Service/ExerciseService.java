package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.Exercise;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExerciseService {
    Exercise findFirstById(Integer id);
    Exercise findFirstByName(String name);

    public String Insert(Exercise exercise);

    public Exercise ReadByName(String name);
    public String Delete(Exercise exercise);

    List<Exercise> findAllByIdGreaterThanEqual(Integer id);
}
