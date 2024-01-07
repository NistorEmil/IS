package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Exercise;
import com.example.TestProiectBackend.Repository.ExerciseRepository;
import com.example.TestProiectBackend.Service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImplementation implements ExerciseService {
    @Autowired
    private final ExerciseRepository exerciseRepository;
    //@Autowired
    //private ExerciseRepository exerciseRepository;


    @Override
    public Exercise findFirstById(Integer id) {
        return exerciseRepository.findFirstById(id);
    }

    @Override
    public Exercise findFirstByName(String name){
        return exerciseRepository.findFirstByName(name);
    }

    @Override
    public void Insert(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    @Override
    public Exercise ReadByName(String name) {
        Exercise exercise = exerciseRepository.findFirstByName(name);
        return exercise;
    }
}
