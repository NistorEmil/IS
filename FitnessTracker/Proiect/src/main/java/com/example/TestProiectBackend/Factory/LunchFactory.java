package com.example.TestProiectBackend.Factory;

import com.example.TestProiectBackend.Controller.AlimentController;
import com.example.TestProiectBackend.DTO.MealAux;
import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Lunch;
import com.example.TestProiectBackend.Service.Implementation.AlimentServiceImplementation;
import com.example.TestProiectBackend.Service.Implementation.LunchServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Lunch")
@RequiredArgsConstructor

public class LunchFactory implements MealFactory {
    private final LunchServiceImplementation lunchServiceImplementation;
    private final AlimentServiceImplementation alimentServiceImplementation;

    @PostMapping("/Insert")
    public void createMeal(@RequestBody MealAux lunchAux){
        List<Aliment> aliments = new ArrayList<>();
        int i=0;
        for(String alimentName: lunchAux.getAlimentNames())
        {
            Aliment aliment = alimentServiceImplementation.findFirstByName(alimentName);
            if(aliment != null) {
                aliment.setGramaj(lunchAux.getGramaje().get(i));
                aliments.add(aliment);
                i++;
            }
        }

        Integer calories = 0;
        for(Aliment aliment: aliments)
        {
            calories = calories + aliment.getCaloriesPer100g()*aliment.getGramaj()/100;
        }
        Lunch lunch = new Lunch(lunchAux.getName(), aliments, calories);
        lunchServiceImplementation.Insert(lunch);
        System.out.println(lunch);
    }
    /*
    @PostMapping("/GetById")
    public ResponseEntity ReadByID(@RequestBody Integer id){
        Breakfast breakfast = breakfastServiceImplementation.ReadById(id);
        return ResponseEntity.status(HttpStatus.OK).body(breakfast);
    }

     */
}
