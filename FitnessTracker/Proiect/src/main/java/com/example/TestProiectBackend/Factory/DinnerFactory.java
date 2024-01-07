package com.example.TestProiectBackend.Factory;

import com.example.TestProiectBackend.Controller.AlimentController;
import com.example.TestProiectBackend.DTO.MealAux;
import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Dinner;
import com.example.TestProiectBackend.Service.Implementation.AlimentServiceImplementation;
import com.example.TestProiectBackend.Service.Implementation.DinnerServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Dinner")
@RequiredArgsConstructor

public class DinnerFactory implements MealFactory {
    private final DinnerServiceImplementation dinnerServiceImplementation;
    private final AlimentServiceImplementation alimentServiceImplementation;

    @PostMapping("/Insert")
    public void createMeal(@RequestBody MealAux dinnerAux){
        List<Aliment> aliments = new ArrayList<>();
        int i=0;
        for(String alimentName: dinnerAux.getAlimentNames())
        {
            Aliment aliment = alimentServiceImplementation.findFirstByName(alimentName);
            if(aliment != null) {
                aliment.setGramaj(dinnerAux.getGramaje().get(i));
                aliments.add(aliment);
                i++;
            }
        }

        Integer calories = 0;
        for(Aliment aliment: aliments)
        {
            calories = calories + aliment.getCaloriesPer100g()*aliment.getGramaj()/100;
        }
        Dinner dinner = new Dinner(dinnerAux.getName(), aliments, calories);
        dinnerServiceImplementation.Insert(dinner);
        System.out.println(dinner);
    }
    /*
    @PostMapping("/GetById")
    public ResponseEntity ReadByID(@RequestBody Integer id){
        Breakfast breakfast = breakfastServiceImplementation.ReadById(id);
        return ResponseEntity.status(HttpStatus.OK).body(breakfast);
    }

     */
}

