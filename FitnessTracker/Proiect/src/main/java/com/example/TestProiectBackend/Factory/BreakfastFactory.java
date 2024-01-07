package com.example.TestProiectBackend.Factory;

import com.example.TestProiectBackend.Controller.AlimentController;
import com.example.TestProiectBackend.DTO.MealAux;
import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Breakfast;
import com.example.TestProiectBackend.Service.Implementation.AlimentServiceImplementation;
import com.example.TestProiectBackend.Service.Implementation.BreakfastServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Breakfast")
@RequiredArgsConstructor

    public class BreakfastFactory implements MealFactory {
    private final BreakfastServiceImplementation breakfastServiceImplementation;
    private final AlimentServiceImplementation alimentServiceImplementation;

    @PostMapping("/Insert")
    public void createMeal(@RequestBody MealAux breakfastAux){
        List<Aliment> aliments = new ArrayList<>();
        int i=0;
        for(String alimentName: breakfastAux.getAlimentNames())
        {
            Aliment aliment = alimentServiceImplementation.findFirstByName(alimentName);
            if(aliment != null) {
                aliment.setGramaj(breakfastAux.getGramaje().get(i));
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
        Integer calories = 0;
        for(Aliment aliment: aliments)
        {
            calories = calories + aliment.getCaloriesPer100g()*aliment.getGramaj()/100;
        }
        Breakfast breakfast = new Breakfast(breakfastAux.getName(), aliments, calories);
        breakfastServiceImplementation.Insert(breakfast);
        System.out.println(breakfast);
    }
    /*
    @PostMapping("/GetById")
    public ResponseEntity ReadByID(@RequestBody Integer id){
        Breakfast breakfast = breakfastServiceImplementation.ReadById(id);
        return ResponseEntity.status(HttpStatus.OK).body(breakfast);
    }

     */
}
