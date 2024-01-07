package com.example.TestProiectBackend.Controller;

import com.example.TestProiectBackend.Model.Exercise;
import com.example.TestProiectBackend.Model.Person;
import com.example.TestProiectBackend.Model.Workout;
import com.example.TestProiectBackend.Model.WorkoutPlan;
import com.example.TestProiectBackend.DTO.WorkoutPlanAux;
import com.example.TestProiectBackend.Service.Implementation.PersonServiceImplementation;
import com.example.TestProiectBackend.Service.Implementation.WorkoutPlanServiceImplementation;
import com.example.TestProiectBackend.Service.Implementation.WorkoutServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/WorkoutPlan")
@RequiredArgsConstructor

public class WorkoutPlanController {

    private Integer id = 0;

    private final WorkoutPlanServiceImplementation workoutPlanServiceImplementation;

    private final WorkoutServiceImplementation workoutServiceImplementation;

    @PostMapping("/Insert")
    public void insert(@RequestBody WorkoutPlanAux workoutplanAux){
        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setId(workoutplanAux.getId());
        List<Workout> workouts = new ArrayList<>();
        for(String workoutName : workoutplanAux.getWorkoutNames())
        {

            workouts.add(workoutServiceImplementation.findFirstByName(workoutName));
        }
        workoutPlan.setWorkouts(workouts);
        workoutPlanServiceImplementation.Insert(workoutPlan);
        System.out.println(workoutPlan);
    }

    @PostMapping("/GetByName")
    public ResponseEntity ReadById(@RequestBody Integer id){
        WorkoutPlan workoutPlan = workoutPlanServiceImplementation.ReadById(id);
        return ResponseEntity.status(HttpStatus.OK).body(workoutPlan);
    }

    @PostMapping("/Plan")
    public void plan(@RequestBody Person person){
        WorkoutPlan workoutPlan;
        if(person.getNumberOfTrainingDays().equals(3))
        {
            workoutPlan = workoutPlanServiceImplementation.findFirstById(1);
        }
        else if(person.getNumberOfTrainingDays().equals(4))
        {
            workoutPlan = workoutPlanServiceImplementation.findFirstById(2);
        }
        else
        {
            workoutPlan = workoutPlanServiceImplementation.findFirstById(3);
        }
        System.out.println("\nAntrenamente :\n");
        for(Workout workout : workoutPlan.getWorkouts())
        {
            System.out.println(workout.getName());
            for(Exercise exercise:workout.getExercises())
            {
                System.out.println(exercise.getName());
            }
        }
    }

}
