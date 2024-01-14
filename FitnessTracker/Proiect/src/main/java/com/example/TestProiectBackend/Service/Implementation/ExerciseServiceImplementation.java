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
    public String Insert(Exercise exercise) {
        if (exercise.getName().isEmpty() || exercise.getType().isEmpty() || exercise.getMuscleTargeted().isEmpty() || exercise.getRepsPerSet() == null || exercise.getNumberOfSets() == null) {
            return "All fields are required for exercise";
        } else {
            exerciseRepository.save(exercise);
            return "Exercise added successfully";
        }
    }

    @Override
    public Exercise ReadByName(String name) {
        Exercise exercise = exerciseRepository.findFirstByName(name);
        return exercise;
    }
    @Override
    public String Delete(Exercise exercise) {
        if (exercise.getName().isEmpty()) {
            return "Exercise name needed to be deleted";
        } else {
            exerciseRepository.delete(exercise);
            return "Exercise deleted successfully";
        }
    }
    @Override
    public List<Exercise> findAllByIdGreaterThanEqual(Integer id)
    {
        return exerciseRepository.findAllByIdGreaterThanEqual(id);
    }
}
