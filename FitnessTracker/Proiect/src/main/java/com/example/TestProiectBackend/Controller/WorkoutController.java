package com.example.TestProiectBackend.Controller;

import com.example.TestProiectBackend.DTO.WorkoutAux;
import com.example.TestProiectBackend.Model.Exercise;
import com.example.TestProiectBackend.Model.Person;
import com.example.TestProiectBackend.Model.Workout;
import com.example.TestProiectBackend.Service.Implementation.ExerciseServiceImplementation;
import com.example.TestProiectBackend.Service.Implementation.WorkoutServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Workout")
@RequiredArgsConstructor

public class WorkoutController {

    private final WorkoutServiceImplementation workoutServiceImplementation;

    private final ExerciseServiceImplementation exerciseServiceImplementation;

    @PostMapping("/Insert")
    public ResponseEntity<Object> insert(@RequestBody WorkoutAux workoutAux){
        Workout workout = new Workout();
        workout.setWorkoutDuration(workoutAux.getWorkoutDuration());
        workout.setName(workoutAux.getName());
        List<Exercise> exercises = new ArrayList<>();
        for(String exerciseName : workoutAux.getExercises())
        {
            exercises.add(exerciseServiceImplementation.findFirstByName(exerciseName));
        }
        workout.setExercises(exercises);

        String string = workoutServiceImplementation.Insert(workout);
        if(string.equals("Workout added succesfully")){
            return ResponseEntity.ok(string);
        }
        else {
            return ResponseEntity.badRequest().body(string);
        }
    }

    @PostMapping("/Delete")
    public ResponseEntity<Object> delete(@RequestBody Workout workout){
        System.out.println(workout);
        String string = workoutServiceImplementation.Delete(workout);
        if(string.equals("Workout deleted succesfully")){
            return ResponseEntity.ok(string);
        }
        else {
            return ResponseEntity.badRequest().body(string);
        }
    }

    @PostMapping("/GetByName")
    public ResponseEntity ReadByName(@RequestBody String name){
        Workout workout = workoutServiceImplementation.ReadByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(workout);
    }
}
