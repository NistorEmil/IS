package com.example.TestProiectBackend.Factory;

import com.example.TestProiectBackend.DTO.MealAux;
import com.example.TestProiectBackend.Model.*;
import com.example.TestProiectBackend.Repository.CosAlimentGramajRepository;
import com.example.TestProiectBackend.Service.Implementation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final GramajServiceImplementation gramajServiceImplementation;
    private final CosAlimentGramajServiceImplementation cosAlimentGramajServiceImplementation;


    @PostMapping("/Insert")
    public ResponseEntity<Object> createMeal(@RequestBody MealAux breakfastAux) {
        List<Aliment> aliments = new ArrayList<>();
        int i = 0;
        if (breakfastAux.getAlimentNames() == null)
        {
            return ResponseEntity.badRequest().body("Nu ai introdus alimentele");
        }
        else if (breakfastAux.getName() == null)
        {
            return ResponseEntity.badRequest().body("Nu ai introdus numele");
        }
        for (String alimentName : breakfastAux.getAlimentNames()) {
            Aliment aliment = alimentServiceImplementation.findFirstByName(alimentName);
            if (aliment != null) {
                if(breakfastAux.getGramaje() == null)
                {
                    return ResponseEntity.badRequest().body("Nu ai introdus gramajele");
                }
                Gramaj gramaj = new Gramaj(breakfastAux.getGramaje().get(i));
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
            calories = calories + aliment.getCaloriesPer100g() * breakfastAux.getGramaje().get(i)/100;
            i++;
        }
        Breakfast breakfast = new Breakfast(breakfastAux.getName(), aliments, calories);
        breakfastServiceImplementation.Insert(breakfast);
        System.out.println(breakfastAux);
        return ResponseEntity.ok("Micul Dejun a fost introdus");
    }
}
