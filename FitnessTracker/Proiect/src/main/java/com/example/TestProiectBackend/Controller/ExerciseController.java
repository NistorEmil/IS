package com.example.TestProiectBackend.Controller;

import com.example.TestProiectBackend.Model.Exercise;
import com.example.TestProiectBackend.Model.Person;
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
    public ResponseEntity<Object> Insert(@RequestBody Exercise exercise)
    {
        String string = exerciseServiceImplementation.Insert(exercise);
        if(string.equals("Exercise added succesfully")){
            return ResponseEntity.ok(string);
        }
        else {
            return ResponseEntity.badRequest().body(string);
        }
    }

    @PostMapping("/Delete")
    public ResponseEntity<Object> delete(@RequestBody Exercise exercise){
        System.out.println(exercise);
        String string = exerciseServiceImplementation.Delete(exercise);
        if(string.equals("Exercise deleted succesfully")){
            return ResponseEntity.ok(string);
        }
        else {
            return ResponseEntity.badRequest().body(string);
        }
    }

    @PostMapping("/GetById")
    public ResponseEntity ReadByName(@RequestBody String name){
        Exercise exercise = exerciseServiceImplementation.ReadByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(exercise);
    }

}
