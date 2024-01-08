package com.example.TestProiectBackend.Controller;

import com.example.TestProiectBackend.DTO.AddOneDayAlimentationToPerson;
import com.example.TestProiectBackend.DTO.AddWorkoutToPerson;
import com.example.TestProiectBackend.DTO.BreakfastDTO;
import com.example.TestProiectBackend.Model.*;
import com.example.TestProiectBackend.Service.Implementation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Person")
@RequiredArgsConstructor

public class PersonController {

    private final PersonServiceImplementation personServiceImplementation;
    private final WorkoutServiceImplementation workoutServiceImplementation;
    private final WorkoutPlanController workoutPlanController;
    private final RecomendedAlimentsController recomendedAlimentsController;
    private final LunchServiceImplementation lunchServiceImplementation;
    private final BreakfastServiceImplementation breakfastServiceImplementation;
    private final DinnerServiceImplementation dinnerServiceImplementation;
    private final SnackServiceImplementation snackServiceImplementation;
    private final AlimentServiceImplementation alimentServiceImplementation;
    private final CosPersonMasaServiceImplementation cosServiceImplementation;
    private final CosPersonWorkoutServiceImplementation cosPersonWorkoutServiceImplementation;

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
    public ResponseEntity<Object> insert(@RequestBody Person person)
    {
        String string = personServiceImplementation.Insert(person);
        if(string.equals("Person added succesfully")){
            return ResponseEntity.ok(string);
        }
        else {
            return ResponseEntity.badRequest().body(string);
        }
    }

    @PostMapping("/Delete")
    public ResponseEntity<Object> delete(@RequestBody Person person){
        System.out.println(person);
        String string = personServiceImplementation.Delete(person);
        if(string.equals("Person deleted succesfully")){
            return ResponseEntity.ok(string);
        }
        else {
            return ResponseEntity.badRequest().body(string);
        }
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
        ///Breakfast breakfast = breakfastServiceImplementation.findFirstByName(breakfastDTO.getBreakfastName());
        ///breakfast.setDay("Luni");
        ///breakfast.getPersonList().add(personServiceImplementation.findFirstById(breakfastDTO.getPersonId()));
        //breakfastServiceImplementation.Insert(breakfast);
        ///personServiceImplementation.findFirstById(breakfastDTO.getPersonId()).getBreakfastList().add(breakfast);
        //System.out.println(breakfast);
    }

    @PostMapping("/FindByNume")
    public ResponseEntity<Object> ReadByNume(@RequestBody Person person){
        if(person.getName().isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No person selected");
        }

        Person person1 = personServiceImplementation.findFirstByName(person.getName());
        System.out.println(person1.getName());
        List<Breakfast> breakfastsList = cosServiceImplementation.getAllBreakfastsByPersonId(person1.getId());
        System.out.println(breakfastsList);

        if (breakfastsList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found for that person");
        }

        return ResponseEntity.status(HttpStatus.OK).body(breakfastsList);
    }

    /*
    @PostMapping("/UpdateBreakfastPerson")
    public ResponseEntity<Object> saveBreakfast(@RequestBody AddBreakfastsToPerson addBreakfastsToPerson){
        System.out.println(addBreakfastsToPerson.getBreakfastNames());
        System.out.println(addBreakfastsToPerson.getPersonId());

        List<String> breakfastNames = addBreakfastsToPerson.getBreakfastNames();
        for (String breakfastName : breakfastNames) {
            Cos cos = new Cos(addBreakfastsToPerson.getPersonId(), breakfastName);
            cosServiceImplementation.Insert(cos);
            Person person = personServiceImplementation.findFirstById(addBreakfastsToPerson.getPersonId());
            List<Cos> cosuriPerson = person.getCosuri();
            cosuriPerson.add(cos);
            person.setCosuri(cosuriPerson);
            personServiceImplementation.Save(person);

            Breakfast breakfast1 = breakfastServiceImplementation.findFirstByName(breakfastName);
            List<Cos> cosuriProduct = breakfast1.getCosuri();
            cosuriProduct.add(cos);
            breakfast1.setCosuri(cosuriProduct);
            breakfastServiceImplementation.Save(breakfast1);
        }
        return ResponseEntity.ok("Mic dejun-urile au fost adaugate cu succes");

    }

     */
    @PostMapping("/UpdateAlimentationPerson")
    public ResponseEntity<Object> saveBreakfast(@RequestBody AddOneDayAlimentationToPerson addOneDayAlimentationToPerson){
        System.out.println(addOneDayAlimentationToPerson.getBreakfastName());
        System.out.println(addOneDayAlimentationToPerson.getLunchName());
        System.out.println(addOneDayAlimentationToPerson.getDinnerName());
        System.out.println(addOneDayAlimentationToPerson.getPersonId());

        String breakfastName = addOneDayAlimentationToPerson.getBreakfastName();
        String lunchName = addOneDayAlimentationToPerson.getLunchName();
        String dinnerName = addOneDayAlimentationToPerson.getDinnerName();

        CosPersonMasa cos = new CosPersonMasa(addOneDayAlimentationToPerson.getPersonId(), addOneDayAlimentationToPerson.getBreakfastName(), addOneDayAlimentationToPerson.getLunchName(), addOneDayAlimentationToPerson.getDinnerName());
        cosServiceImplementation.Insert(cos);
        Person person = personServiceImplementation.findFirstById(addOneDayAlimentationToPerson.getPersonId());
        List<CosPersonMasa> cosuriPerson = person.getCosuri();
        cosuriPerson.add(cos);
        person.setCosuri(cosuriPerson);
        personServiceImplementation.Save(person);

        Breakfast breakfast = breakfastServiceImplementation.findFirstByName(breakfastName);
        Lunch lunch = lunchServiceImplementation.findFirstByName(lunchName);
        Dinner dinner = dinnerServiceImplementation.findFirstByName(dinnerName);
        breakfast.setDay(addOneDayAlimentationToPerson.getDay());
        lunch.setDay(addOneDayAlimentationToPerson.getDay());
        dinner.setDay(addOneDayAlimentationToPerson.getDay());
        List<CosPersonMasa> cosuriBreakfast = breakfast.getCosuri();
        List<CosPersonMasa> cosuriLunch = lunch.getCosuri();
        List<CosPersonMasa> cosuriDinner = dinner.getCosuri();
        cosuriBreakfast.add(cos);
        cosuriLunch.add(cos);
        cosuriDinner.add(cos);
        breakfast.setCosuri(cosuriBreakfast);
        lunch.setCosuri(cosuriLunch);
        dinner.setCosuri(cosuriDinner);

        breakfastServiceImplementation.Save(breakfast);
        lunchServiceImplementation.Save(lunch);
        dinnerServiceImplementation.Save(dinner);
        return ResponseEntity.ok("Alimentatia a fost adaugata cu succes");

    }


    @PostMapping("/UpdateWorkoutPerson")
    public ResponseEntity<Object> saveWorkout(@RequestBody AddWorkoutToPerson addWorkoutToPerson){

        String workoutName = addWorkoutToPerson.getWorkoutName();

        CosPersonWorkout cos = new CosPersonWorkout(addWorkoutToPerson.getPersonId(), workoutName);
        cosPersonWorkoutServiceImplementation.Insert(cos);
        Person person = personServiceImplementation.findFirstById(addWorkoutToPerson.getPersonId());
        List<CosPersonWorkout> cosuriPerson = person.getCosPersonWorkouts();
        cosuriPerson.add(cos);
        person.setCosPersonWorkouts(cosuriPerson);
        personServiceImplementation.Save(person);

        Workout workout = workoutServiceImplementation.findFirstByName(workoutName);
        workout.setDay(addWorkoutToPerson.getDay());
        List<CosPersonWorkout> cosuriWorkout = workout.getCosPersonWorkouts();
        cosuriWorkout.add(cos);
        workout.setCosPersonWorkouts(cosuriWorkout);

        workoutServiceImplementation.Save(workout);
        return ResponseEntity.ok("Alimentatia a fost adaugata cu succes");

    }

}