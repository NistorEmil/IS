package com.example.TestProiectBackend.Controller;

import com.example.TestProiectBackend.Model.Exercise;
import com.example.TestProiectBackend.Service.Implementation.ExerciseServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/Exercise")
@RequiredArgsConstructor

public class ExerciseController {

    private final ExerciseServiceImplementation exerciseServiceImplementation;

    @PostMapping("/Insert")
    public void insert(@RequestBody Exercise exercise) {
        Exercise existingExercise = exerciseServiceImplementation.findFirstByName(exercise.getName());
        if (existingExercise == null) {
            exerciseServiceImplementation.Insert(exercise);
            System.out.println(exercise);
        } else {
            System.out.println("Exercițiul cu numele dat deja există în baza de date.");
        }
    }

    @PostMapping("/GetById")
    public ResponseEntity ReadByName(@RequestBody String name){
        Exercise exercise = exerciseServiceImplementation.ReadByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(exercise);
    }

}
