package com.example.TestProiectBackend.Factory;

import com.example.TestProiectBackend.DTO.MealAux;
import com.example.TestProiectBackend.Model.*;
import com.example.TestProiectBackend.Repository.CosAlimentGramajRepository;
import com.example.TestProiectBackend.Service.Implementation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    private final GramajServiceImplementation gramajServiceImplementation;
    private final CosAlimentGramajServiceImplementation cosAlimentGramajServiceImplementation;


    @PostMapping("/Insert")
    public ResponseEntity<Object> createMeal(@RequestBody MealAux dinnerAux) {
        List<Aliment> aliments = new ArrayList<>();
        int i = 0;
        if (dinnerAux.getAlimentNames() == null)
        {
            return ResponseEntity.badRequest().body("Nu ai introdus alimentele");
        }
        else if (dinnerAux.getName() == null)
        {
            return ResponseEntity.badRequest().body("Nu ai introdus numele");
        }
        for (String alimentName : dinnerAux.getAlimentNames()) {
            Aliment aliment = alimentServiceImplementation.findFirstByName(alimentName);
            if (aliment != null) {
                if(dinnerAux.getGramaje() == null)
                {
                    return ResponseEntity.badRequest().body("Nu ai introdus gramajele");
                }
                Gramaj gramaj = new Gramaj(dinnerAux.getGramaje().get(i));
                CosAlimentGramaj cosAlimentGramaj = new CosAlimentGramaj(aliment.getId(), gramaj.getGramaj());

                if(gramaj.getCosuri() == null)
                {
                    List<CosAlimentGramaj> gramajCosuri = new ArrayList<>();
                    gramajCosuri.add(cosAlimentGramaj);
                    gramaj.setCosuri(gramajCosuri);
                }
                else
                {
                    List<CosAlimentGramaj> gramajCosuri = gramaj.getCosuri();
                    gramajCosuri.add(cosAlimentGramaj);
                    gramaj.setCosuri(gramajCosuri);
                }

                List<CosAlimentGramaj> alimentCosuri = aliment.getCosuri();
                alimentCosuri.add(cosAlimentGramaj);
                aliment.setCosuri(alimentCosuri);
                cosAlimentGramajServiceImplementation.Insert(cosAlimentGramaj);
                gramajServiceImplementation.Insert(gramaj);
                alimentServiceImplementation.Save(aliment);

                //
                //aliment.setGramaj(lunchAux.getGramaje().get(i));
                aliments.add(aliment);
                i++;
            }
        }

        i = 0;
        Integer calories = 0;
        for (Aliment aliment : aliments) {
            //calories = calories + aliment.getCaloriesPer100g() * aliment.getGramaj()/100;
            calories = calories + aliment.getCaloriesPer100g() * dinnerAux.getGramaje().get(i)/100;
            i++;
        }
        Dinner dinner = new Dinner(dinnerAux.getName(), aliments, calories);
        dinnerServiceImplementation.Insert(dinner);
        System.out.println(dinnerAux);
        return ResponseEntity.ok("Cina a fost introdusa");
    }
    /*
    @PostMapping("/GetById")
    public ResponseEntity ReadByID(@RequestBody Integer id){
        Breakfast breakfast = breakfastServiceImplementation.ReadById(id);
        return ResponseEntity.status(HttpStatus.OK).body(breakfast);
    }

     */
}

