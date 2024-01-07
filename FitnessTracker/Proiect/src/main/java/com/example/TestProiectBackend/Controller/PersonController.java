package com.example.TestProiectBackend.Controller;

import com.example.TestProiectBackend.DTO.BreakfastDTO;
import com.example.TestProiectBackend.DTO.MealAux;
import com.example.TestProiectBackend.Factory.BreakfastFactory;
import com.example.TestProiectBackend.Model.*;
import com.example.TestProiectBackend.Service.BreakfastService;
import com.example.TestProiectBackend.Service.Implementation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Person")
@RequiredArgsConstructor

public class PersonController {

    private final PersonServiceImplementation personServiceImplementation;

    private final WorkoutPlanController workoutPlanController;
    private final RecomendedAlimentsController recomendedAlimentsController;
    private final LunchServiceImplementation lunchServiceImplementation;
    private final BreakfastServiceImplementation breakfastServiceImplementation;
    private final DinnerServiceImplementation dinnerServiceImplementation;
    private final SnackServiceImplementation snackServiceImplementation;
    private final AlimentServiceImplementation alimentServiceImplementation;

    /*
    @PostMapping("/Insert")
    public void insert(@RequestBody Person person){
        personServiceImplementation.Insert(person);
        System.out.println(person);
    }

    @PostMapping("/GetById")
    public ResponseEntity ReadByID(@RequestBody Integer id){
        Person person = personServiceImplementation.ReadById(id);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

     */

    @PostMapping("/Breakfast")
    public void breakfast(@RequestBody Person person)
    {
        Double calories = personServiceImplementation.computeCalories(person);
        Integer breakfastCalories = calories.intValue() / 5;
        Breakfast breakfast;
        if(person.getObjective().equals("weight loss"))
        {
            breakfast = breakfastServiceImplementation.findFirstByCaloriesIsLessThan(breakfastCalories-50);
        }
        else
        {
            breakfast = breakfastServiceImplementation.findFirstByCaloriesIsGreaterThan(breakfastCalories + 50);
        }
        System.out.println(breakfast);
    }

    @PostMapping("/Lunch")
    public void lunch(@RequestBody Person person)
    {
        Double calories = personServiceImplementation.computeCalories(person);
        Integer lunchCalories = calories.intValue() / 4;
        Lunch lunch;
        if(person.getObjective().equals("weight loss"))
        {
            lunch = lunchServiceImplementation.findFirstByCaloriesIsLessThan(lunchCalories-50);
        }
        else
        {
            lunch = lunchServiceImplementation.findFirstByCaloriesIsGreaterThan(lunchCalories + 50);
        }
        System.out.println(lunch);
    }

    @PostMapping("/Dinner")
    public void dinner(@RequestBody Person person)
    {
        Double calories = personServiceImplementation.computeCalories(person);
        Integer dinnerCalories = calories.intValue() / 4;
        Dinner dinner;
        if(person.getObjective().equals("weight loss"))
        {
            dinner = dinnerServiceImplementation.findFirstByCaloriesIsLessThan(dinnerCalories-50);
        }
        else
        {
            dinner = dinnerServiceImplementation.findFirstByCaloriesIsGreaterThan(dinnerCalories + 50);
        }
        System.out.println(dinner);
    }

    @PostMapping("/Snack")
    public void snack(@RequestBody Person person)
    {
        Double calories = personServiceImplementation.computeCalories(person);
        Integer snackCalories = calories.intValue() / 6;
        Snack snack;
        if(person.getObjective().equals("weight loss"))
        {
            snack = snackServiceImplementation.findFirstByCaloriesIsLessThan(snackCalories-50);
        }
        else
        {
            snack = snackServiceImplementation.findFirstByCaloriesIsGreaterThan(snackCalories + 50);
        }
        System.out.println(snack);
    }

    @PostMapping("/Calories")
    public void calories(@RequestBody Person person)
    {
        personServiceImplementation.computeCalories(person);
    }

    @PostMapping("/Results")
    public void results(@RequestBody Person person)
    {
        workoutPlanController.plan(person);
        recomendedAlimentsController.alimentation(person);
    }

    @PostMapping("/Insert")
    public void insert(@RequestBody Person person)
    {
        personServiceImplementation.Insert(person);
    }

    @PostMapping("/InsertBreakfast")
    public void insertBreakfast(@RequestBody BreakfastDTO breakfastDTO){
        /*
        List<Aliment> aliments = new ArrayList<>();
        int i=0;
        for(String alimentName: breakfastDTO.getBreakfastAux().getAlimentNames())
        {
            Aliment aliment = alimentServiceImplementation.findFirstByName(alimentName);
            if(aliment != null) {
                aliment.setGramaj(breakfastDTO.getBreakfastAux().getGramaje().get(i));
                aliments.add(aliment);
                i++;
            }
        }
/*
        for(int i = 0; i < aliments.size(); i++)
        {
            Integer gramaj = breakfastAux.getGramaje().get(i);
            aliments.get(i).setGramaj(gramaj);
        }
*/
        /*
        Integer calories = 0;
        for(Aliment aliment: aliments)
        {
            calories = calories + aliment.getCaloriesPer100g()*aliment.getGramaj()/100;
        }
         */
        Breakfast breakfast = breakfastServiceImplementation.findFirstByName(breakfastDTO.getBreakfastName());
        breakfast.setDay("Luni");
        breakfast.getPersonList().add(personServiceImplementation.findFirstById(breakfastDTO.getPersonId()));
        //breakfastServiceImplementation.Insert(breakfast);
        personServiceImplementation.findFirstById(breakfastDTO.getPersonId()).getBreakfastList().add(breakfast);
        //System.out.println(breakfast);
    }
}