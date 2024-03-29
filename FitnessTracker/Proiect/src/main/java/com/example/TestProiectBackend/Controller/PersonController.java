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

import java.util.ArrayList;
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

    private final CosPersonMasaServiceImplementation cosPersonMasaServiceImplementation;

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
    public ResponseEntity<Object> breakfast(@RequestBody Person person)
    {
        Double calories = personServiceImplementation.computeCalories(person);
        Integer breakfastCalories = calories.intValue() / 5;
        Breakfast breakfast;
        if(person.getObjective().equals("weight loss"))
        {
            breakfast = breakfastServiceImplementation.findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(breakfastCalories-150, breakfastCalories-50);
        }
        else
        {
            breakfast = breakfastServiceImplementation.findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(breakfastCalories+50, breakfastCalories+150);
        }
        System.out.println(breakfast);
        if(breakfast != null){
            return ResponseEntity.ok(breakfast);
        }
        else {
            return ResponseEntity.badRequest().body("Not such breakfast");
        }
    }

    @PostMapping("/Lunch")
    public ResponseEntity<Object> lunch(@RequestBody Person person)
    {
        Double calories = personServiceImplementation.computeCalories(person);
        Integer lunchCalories = calories.intValue() / 4;
        Lunch lunch;
        if(person.getObjective().equals("weight loss"))
        {
            lunch = lunchServiceImplementation.findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(lunchCalories-150, lunchCalories-50);
        }
        else
        {
            lunch = lunchServiceImplementation.findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(lunchCalories+50, lunchCalories+150);
        }
        System.out.println(lunch);
        if(lunch != null){
            return ResponseEntity.ok(lunch);
        }
        else {
            return ResponseEntity.badRequest().body("Not such lunch");
        }
    }

    @PostMapping("/Dinner")
    public ResponseEntity<Object> dinner(@RequestBody Person person)
    {
        Double calories = personServiceImplementation.computeCalories(person);
        Integer dinnerCalories = calories.intValue() / 4;
        Dinner dinner;
        if(person.getObjective().equals("weight loss"))
        {
            dinner = dinnerServiceImplementation.findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(dinnerCalories-150, dinnerCalories-50);
        }
        else
        {
            dinner = dinnerServiceImplementation.findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(dinnerCalories+50, dinnerCalories+150);
        }
        System.out.println(dinner);
        if(dinner != null){
            return ResponseEntity.ok(dinner);
        }
        else {
            return ResponseEntity.badRequest().body("Not such dinner");
        }
    }

    @PostMapping("/Snack")
    public ResponseEntity<Object> snack(@RequestBody Person person)
    {
        Double calories = personServiceImplementation.computeCalories(person);
        Integer snackCalories = calories.intValue() / 6;
        Snack snack;
        if(person.getObjective().equals("weight loss"))
        {
            snack = snackServiceImplementation.findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(snackCalories-75, snackCalories-25);
        }
        else
        {
            snack = snackServiceImplementation.findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(snackCalories+25, snackCalories+75);
        }
        System.out.println(snack);
        if(snack != null){
            return ResponseEntity.ok(snack);
        }
        else {
            return ResponseEntity.badRequest().body("Not such snack");
        }
    }

    @PostMapping("/Alimentation")
    public void alimentation(@RequestBody Person person)
    {
        breakfast(person);
        lunch(person);
        dinner(person);
        snack(person);
    }

    @PostMapping("/WorkoutPlan")
    public ResponseEntity<Object> workoutPlan(@RequestBody Person person)
    {
        List<Workout> workouts = new ArrayList<>();
        if(person.getNumberOfTrainingDays() == 2)
        {
            workouts.add(workoutServiceImplementation.findFirstByName("Upper Body Day"));
            workouts.add(workoutServiceImplementation.findFirstByName("Lower Body Day"));
        }
        else if(person.getNumberOfTrainingDays() == 3)
        {
            workouts.add(workoutServiceImplementation.findFirstByName("Push"));
            workouts.add(workoutServiceImplementation.findFirstByName("Pull"));
            workouts.add(workoutServiceImplementation.findFirstByName("Legs"));
        }
        else if(person.getNumberOfTrainingDays() == 4)
        {
            workouts.add(workoutServiceImplementation.findFirstByName("Chest and Shoulders"));
            workouts.add(workoutServiceImplementation.findFirstByName("Back and Rear Delts"));
            workouts.add(workoutServiceImplementation.findFirstByName("Legs"));
            workouts.add(workoutServiceImplementation.findFirstByName("Arms"));
        }

        if(!workouts.isEmpty()){
            return ResponseEntity.ok(workouts);
        }
        else {
            return ResponseEntity.badRequest().body("Not such workout plan for that amount of days");
        }
    }

    @PostMapping("/Calories")
    public ResponseEntity<Double> calories(@RequestBody Person person)
    {
        return ResponseEntity.badRequest().body(personServiceImplementation.computeCalories(person));
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

    @GetMapping("/findAllMeals")
    public ResponseEntity<List<CosPersonMasa>> findAllMeals(@RequestBody Person person){
        Person person1 = personServiceImplementation.findFirstById(person.getId());
        if(person1 == null)
        {
            System.out.println("Persoana nu a fost gasita");
            return ResponseEntity.badRequest().body(null);
        }
        List<CosPersonMasa> cosuri = person1.getCosuri();
        if(cosuri != null)
            return ResponseEntity.status(HttpStatus.OK).body(cosuri);
        else
            return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Person>> find(){
        List<Person> persons = personServiceImplementation.findAllByIdGreaterThanEqual(0);
        for(Person person: persons)
        {
            System.out.println(person);
        }
        if(persons != null)
            return ResponseEntity.status(HttpStatus.OK).body(persons);
        else
            return ResponseEntity.badRequest().body(null);
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
    public ResponseEntity<Object> saveAlimentation(@RequestBody AddOneDayAlimentationToPerson addOneDayAlimentationToPerson){
        System.out.println(addOneDayAlimentationToPerson.getBreakfastName());
        System.out.println(addOneDayAlimentationToPerson.getLunchName());
        System.out.println(addOneDayAlimentationToPerson.getDinnerName());
        System.out.println(addOneDayAlimentationToPerson.getPersonId());

        String breakfastName = addOneDayAlimentationToPerson.getBreakfastName();
        String lunchName = addOneDayAlimentationToPerson.getLunchName();
        String dinnerName = addOneDayAlimentationToPerson.getDinnerName();
        String snackName = addOneDayAlimentationToPerson.getSnackName();

        CosPersonMasa cos = new CosPersonMasa(addOneDayAlimentationToPerson.getPersonId(), addOneDayAlimentationToPerson.getBreakfastName(), addOneDayAlimentationToPerson.getLunchName(), addOneDayAlimentationToPerson.getDinnerName(), addOneDayAlimentationToPerson.getSnackName());
        Person person = personServiceImplementation.findFirstById(addOneDayAlimentationToPerson.getPersonId());
        if(person == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persoana nu a fost gasita");
        }

        if(breakfastName == null || dinnerName == null || lunchName == null || snackName == null || addOneDayAlimentationToPerson.getDay() == null)
        {
            return ResponseEntity.badRequest().body("Completeaza toate field-urile");
        }
        else
        {
            List<CosPersonMasa> cosuriPerson = person.getCosuri();
            cosuriPerson.add(cos);
            person.setCosuri(cosuriPerson);
        }

        Breakfast breakfast = breakfastServiceImplementation.findFirstByName(breakfastName);
        Lunch lunch = lunchServiceImplementation.findFirstByName(lunchName);
        Dinner dinner = dinnerServiceImplementation.findFirstByName(dinnerName);
        Snack snack = snackServiceImplementation.findFirstByName(snackName);

        if(breakfast == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Breakfast-ul nu a fost gasit");
        else if(lunch == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lunch-ul nu a fost gasit");
        else if(dinner == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dinner-ul nu a fost gasit");
        else if(snack == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Snack-ul nu a fost gasit");

        if(breakfast != null && lunch != null && dinner != null && snack != null && addOneDayAlimentationToPerson.getDay() != null) {
            cosServiceImplementation.Insert(cos);
            personServiceImplementation.Save(person);
            breakfast.setDay(addOneDayAlimentationToPerson.getDay());
            lunch.setDay(addOneDayAlimentationToPerson.getDay());
            dinner.setDay(addOneDayAlimentationToPerson.getDay());
            snack.setDay(addOneDayAlimentationToPerson.getDay());
            List<CosPersonMasa> cosuriBreakfast = breakfast.getCosuri();
            List<CosPersonMasa> cosuriLunch = lunch.getCosuri();
            List<CosPersonMasa> cosuriDinner = dinner.getCosuri();
            List<CosPersonMasa> cosuriSnack = snack.getCosuri();
            cosuriBreakfast.add(cos);
            cosuriLunch.add(cos);
            cosuriDinner.add(cos);
            cosuriSnack.add(cos);
            breakfast.setCosuri(cosuriBreakfast);
            lunch.setCosuri(cosuriLunch);
            dinner.setCosuri(cosuriDinner);
            snack.setCosuri(cosuriSnack);
            breakfastServiceImplementation.Save(breakfast);
            lunchServiceImplementation.Save(lunch);
            dinnerServiceImplementation.Save(dinner);
            snackServiceImplementation.Save(snack);
            return ResponseEntity.ok("Alimentatia a fost adaugata cu succes");
        }
        else
        {
            return ResponseEntity.badRequest().body("Trebuie introduse mese valide");
        }
    }

    @PostMapping("/UpdateWorkoutPerson")
    public ResponseEntity<Object> saveWorkout(@RequestBody AddWorkoutToPerson addWorkoutToPerson){

        String workoutName = addWorkoutToPerson.getWorkout().getName();

        CosPersonWorkout cos = new CosPersonWorkout(addWorkoutToPerson.getPersonId(), workoutName);
        cosPersonWorkoutServiceImplementation.Insert(cos);
        Person person = personServiceImplementation.findFirstById(addWorkoutToPerson.getPersonId());
        List<CosPersonWorkout> cosuriPerson = person.getCosPersonWorkouts();
        cosuriPerson.add(cos);
        person.setCosPersonWorkouts(cosuriPerson);
        personServiceImplementation.Save(person);

        Workout workout = workoutServiceImplementation.findFirstByName(workoutName);
        workout.setDay(addWorkoutToPerson.getWorkout().getDay());
        List<CosPersonWorkout> cosuriWorkout = workout.getCosPersonWorkouts();
        cosuriWorkout.add(cos);
        workout.setCosPersonWorkouts(cosuriWorkout);

        workoutServiceImplementation.Save(workout);
        return ResponseEntity.ok("Antrenamentul a fost adaugat cu succes");
    }

    @PostMapping("/DeleteWorkoutPerson")
    public ResponseEntity<Object> deleteWorkout(@RequestBody CosPersonWorkout cosPersonWorkout){
        if(cosPersonWorkout.getWorkoutId() == null || cosPersonWorkout.getPersonId() == null || cosPersonWorkout.getId() == null)
            return ResponseEntity.badRequest().body("Completeaza toate fied-urile");
        Workout workout = workoutServiceImplementation.findFirstByName(cosPersonWorkout.getWorkoutId());
        Person person = personServiceImplementation.findFirstById(cosPersonWorkout.getPersonId());
        if(workout == null || person == null)
        {
            if(workout == null)
                return ResponseEntity.badRequest().body("Workout-ul nu a fost gasit");
            else if(person == null)
                return ResponseEntity.badRequest().body("Persoana nu a fost gasita");
        }
        else
        {
            workout.setDay(null);
            List<CosPersonWorkout> cosuri = workout.getCosPersonWorkouts();
            CosPersonWorkout deletedCos = null;
            if(cosuri == null)
            {
                return ResponseEntity.badRequest().body("Workout nu are cosuri");
            }
            else
            {
                for(CosPersonWorkout cos: cosuri) {
                    if (cos.getId().equals(cosPersonWorkout.getId())) {
                        deletedCos = cos;
                    }
                }
                if(deletedCos != null)
                    cosuri.remove(deletedCos);
                workout.setCosPersonWorkouts(cosuri);
                workoutServiceImplementation.Save(workout);

                cosuri = person.getCosPersonWorkouts();
                deletedCos = null;
                if(cosuri == null)
                {
                    return ResponseEntity.badRequest().body("Persoana nu are cosuri");
                }
                else {
                    for (CosPersonWorkout cos : cosuri) {
                        if (cos.getId().equals(cosPersonWorkout.getId())) {
                            deletedCos = cos;
                        }
                    }
                    if (deletedCos != null)
                        cosuri.remove(deletedCos);
                    person.setCosPersonWorkouts(cosuri);
                    personServiceImplementation.Save(person);
                }
                String string = cosPersonWorkoutServiceImplementation.deleteById(cosPersonWorkout.getId());
                if (string.equals("Workout deleted succesfully")) {
                    return ResponseEntity.ok(string);
                } else {
                    return ResponseEntity.badRequest().body(string);
                }
            }
        }
        return ResponseEntity.ok("Error");
    }

    @GetMapping("/findAllBreakfasts")
    public ResponseEntity<List<Breakfast>> findBreakfasts(@RequestBody Person person){
        List<Breakfast> breakfasts = cosPersonMasaServiceImplementation.getAllBreakfastsByPersonId(person.getId());
        for(Breakfast breakfast: breakfasts)
        {
            breakfast.setCosuri(null);
            System.out.println(breakfast);
        }
        if(breakfasts != null)
            return ResponseEntity.status(HttpStatus.OK).body(breakfasts);
        else
            return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/findAllLunches")
    public ResponseEntity<List<Lunch>> findLunches(@RequestBody Person person){
        List<Lunch> lunches = cosPersonMasaServiceImplementation.getAllLunchesByPersonId(person.getId());
        for(Lunch lunch: lunches)
        {
            lunch.setCosuri(null);
            System.out.println(lunch);
        }
        if(lunches != null)
            return ResponseEntity.status(HttpStatus.OK).body(lunches);
        else
            return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/findAllSnacks")
    public ResponseEntity<List<Snack>> findSnacks(@RequestBody Person person){
        List<Snack> snacks = cosPersonMasaServiceImplementation.getAllSnacksByPersonId(person.getId());
        System.out.println(snacks);
        for(Snack snack: snacks)
        {
            if(snack != null)
                snack.setCosuri(null);
            System.out.println(snack);
        }
        if(snacks != null)
            return ResponseEntity.status(HttpStatus.OK).body(snacks);
        else
            return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/findAllDinners")
    public ResponseEntity<List<Dinner>> findDinners(@RequestBody Person person){
        List<Dinner> dinners = cosPersonMasaServiceImplementation.getAllDinnersByPersonId(person.getId());
        for(Dinner dinner: dinners)
        {
            dinner.setCosuri(null);
            System.out.println(dinner);
        }
        if(dinners != null)
            return ResponseEntity.status(HttpStatus.OK).body(dinners);
        else
            return ResponseEntity.badRequest().body(null);
    }

    @PostMapping("/DeleteBreakfast")
    public ResponseEntity<String > deleteBreakfast(@RequestBody Person person, @RequestBody Breakfast breakfast){
        String string = cosPersonMasaServiceImplementation.deleteByBreakfastIdAndPersonId(breakfast.getName(), person.getId());
        if(string.equals("Breakfast deleted succesfully")){
            return ResponseEntity.ok(string);
        }
        else {
            return ResponseEntity.badRequest().body(string);
        }
    }

    @PostMapping("/DeleteDinner")
    public ResponseEntity<String > deleteDinner(@RequestBody Person person, @RequestBody Dinner dinner){
        String string = cosPersonMasaServiceImplementation.deleteByDinnerIdAndPersonId(dinner.getName(), person.getId());
        if(string.equals("Dinner deleted succesfully")){
            return ResponseEntity.ok(string);
        }
        else {
            return ResponseEntity.badRequest().body(string);
        }
    }

    @PostMapping("/DeleteLunch")
    public ResponseEntity<String > deleteLunch(@RequestBody Person person, @RequestBody Lunch lunch){
        String string = cosPersonMasaServiceImplementation.deleteByLunchIdAndPersonId(lunch.getName(), person.getId());
        if(string.equals("Lunch deleted succesfully")){
            return ResponseEntity.ok(string);
        }
        else {
            return ResponseEntity.badRequest().body(string);
        }
    }

    @PostMapping("/DeleteSnack")
    public ResponseEntity<String > deleteSnack(@RequestBody Person person, @RequestBody Snack snack){
        String string = cosPersonMasaServiceImplementation.deleteBySnackIdAndPersonId(snack.getName(), person.getId());
        if(string.equals("Snack deleted succesfully")){
            return ResponseEntity.ok(string);
        }
        else {
            return ResponseEntity.badRequest().body(string);
        }
    }

    @PostMapping("/DeleteAlimentation")
    public ResponseEntity<String > deleteAlimentation(@RequestBody CosPersonMasa cosPersonMasa) {
        if(cosPersonMasa.getBreakfastId() == null || cosPersonMasa.getDinnerId() == null || cosPersonMasa.getSnackId() == null || cosPersonMasa.getLunchId() == null || cosPersonMasa.getPersonId() == null || cosPersonMasa.getId() == null)
            return ResponseEntity.badRequest().body("Completeaza toate fied-urile");
        Breakfast breakfast =breakfastServiceImplementation.findFirstByName(cosPersonMasa.getBreakfastId());
        Lunch lunch = lunchServiceImplementation.findFirstByName(cosPersonMasa.getLunchId());
        Dinner dinner = dinnerServiceImplementation.findFirstByName(cosPersonMasa.getDinnerId());
        Snack snack = snackServiceImplementation.findFirstByName(cosPersonMasa.getSnackId());
        Person person = personServiceImplementation.findFirstById(cosPersonMasa.getPersonId());
        if(breakfast == null || lunch == null || dinner == null || snack == null || person == null) {
            if (breakfast == null)
                return ResponseEntity.badRequest().body("Breakfast-ul nu a fost gasit");
            if (lunch == null)
                return ResponseEntity.badRequest().body("Lunch-ul nu a fost gasit");
            if (dinner == null)
                return ResponseEntity.badRequest().body("Dinner-ul nu a fost gasit");
            if (snack == null)
                return ResponseEntity.badRequest().body("Snack-ul nu a fost gasit");
            if (person == null)
                return ResponseEntity.badRequest().body("Persoana nu a fost gasita");
        }
        else {

            breakfast.setDay(null);
            List<CosPersonMasa> cosuri = breakfast.getCosuri();
            CosPersonMasa deletedCos = null;
            if(cosuri == null)
            {
                return ResponseEntity.badRequest().body("Breakfast nu are cosuri");
            }
            else
            {
                for(CosPersonMasa cos: cosuri) {
                    if (cos.getId().equals(cosPersonMasa.getId())) {
                        deletedCos = cos;
                    }
                }
                if(deletedCos != null)
                    cosuri.remove(deletedCos);
                breakfast.setCosuri(cosuri);
                breakfastServiceImplementation.Save(breakfast);
            }

            lunch.setDay(null);
            cosuri = lunch.getCosuri();
            deletedCos = null;

            if(cosuri == null)
            {
                return ResponseEntity.badRequest().body("Lunch-ul nu are cosuri");
            }
            else
            {
                for(CosPersonMasa cos: cosuri) {
                    if (cos.getId().equals(cosPersonMasa.getId())) {
                        deletedCos = cos;
                    }
                }
                if(deletedCos != null)
                    cosuri.remove(deletedCos);
                lunch.setCosuri(cosuri);
                lunchServiceImplementation.Save(lunch);
            }

            dinner.setDay(null);
            cosuri = dinner.getCosuri();
            deletedCos = null;

            if(cosuri == null)
            {
                return ResponseEntity.badRequest().body("Dinner-ul nu are cosuri");
            }
            else
            {
                for(CosPersonMasa cos: cosuri) {
                    if (cos.getId().equals(cosPersonMasa.getId())) {
                        deletedCos = cos;
                    }
                }
                if(deletedCos != null)
                    cosuri.remove(deletedCos);
                dinner.setCosuri(cosuri);
                dinnerServiceImplementation.Save(dinner);
            }

            snack.setDay(null);
            cosuri = snack.getCosuri();
            deletedCos = null;

            if(cosuri == null)
            {
                return ResponseEntity.badRequest().body("Snack-ul nu are cosuri");
            }
            else
            {
                for(CosPersonMasa cos: cosuri) {
                    if (cos.getId().equals(cosPersonMasa.getId())) {
                        deletedCos = cos;
                    }
                }
                if(deletedCos != null)
                    cosuri.remove(deletedCos);
                snack.setCosuri(cosuri);
                snackServiceImplementation.Save(snack);
            }


            cosuri = person.getCosuri();
            deletedCos = null;
            if(cosuri == null)
            {
                return ResponseEntity.badRequest().body("Persoana nu are cosuri");
            }
            else {
                for (CosPersonMasa cos : cosuri) {
                    if (cos.getId().equals(cosPersonMasa.getId())) {
                        deletedCos = cos;
                    }
                }
                if (deletedCos != null)
                    cosuri.remove(deletedCos);
                person.setCosuri(cosuri);
                personServiceImplementation.Save(person);
            }
                //breakfastServiceImplementation.Delete(breakfastServiceImplementation.findFirstByName(deleteAlimentationRequest.getCosPersonMasa().getBreakfastId()));
                //dinnerServiceImplementation.Delete(dinnerServiceImplementation.findFirstByName(deleteAlimentationRequest.getCosPersonMasa().getDinnerId()));
                //lunchServiceImplementation.Delete(lunchServiceImplementation.findFirstByName(deleteAlimentationRequest.getCosPersonMasa().getLunchId()));
                //snackServiceImplementation.Delete(snackServiceImplementation.findFirstByName(deleteAlimentationRequest.getCosPersonMasa().getSnackId()));
                //System.out.println(deleteAlimentationRequest.getCosPersonMasa().getId() + " " + deleteAlimentationRequest.getPerson().getId());
            String string = cosPersonMasaServiceImplementation.deleteById(cosPersonMasa.getId());
            if (string.equals("Alimentation deleted succesfully")) {
                return ResponseEntity.ok(string);
            } else {
                return ResponseEntity.badRequest().body(string);
            }

        }
        return ResponseEntity.ok("Error");
    }

}