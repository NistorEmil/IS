package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Breakfast;
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
    public String Insert(Workout workout) {
        if(workout.getName().isEmpty() || workout.getExercises().isEmpty() || workout.getWorkoutDuration() == null){
            return ("All fields are required");
        }
        else
        {
            workoutRepository.save(workout);
            System.out.println(workout);
            return ("Workout added succesfully");
        }
    }


    @Override
    public String Delete(Workout workout){
        if(workout.getName().isEmpty()) {
            return ("Workout needed to be deleted");
        }
        else{
            workoutRepository.delete(workout);
            return ("Workout deleted succesfully");
        }
    }



    @Override
    public Workout ReadByName(String name) {
        Workout workout = workoutRepository.findFirstByName(name);
        return workout;
    }
    @Override
    public String Save(Workout workout) {
        if(workout.getName().isEmpty()){
            //System.out.println("Date insuficiente");
            return ("Name and price fields are required / Select a product");
        }
        else{
            workoutRepository.save(workout);
            return ("Infos updated succesfully");
            //System.out.println(employee);
        }
    }
}
