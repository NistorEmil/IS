package com.example.TestProiectBackend.Factory;

import com.example.TestProiectBackend.DTO.MealAux;
import com.example.TestProiectBackend.Model.*;
import com.example.TestProiectBackend.Repository.CosAlimentGramajRepository;
import com.example.TestProiectBackend.Service.CosAlimentGramajService;
import com.example.TestProiectBackend.Service.Implementation.AlimentServiceImplementation;
import com.example.TestProiectBackend.Service.Implementation.CosAlimentGramajServiceImplementation;
import com.example.TestProiectBackend.Service.Implementation.GramajServiceImplementation;
import com.example.TestProiectBackend.Service.Implementation.SnackServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Snack")
@RequiredArgsConstructor

public class SnackFactory implements MealFactory {
    private final SnackServiceImplementation snackServiceImplementation;
    private final AlimentServiceImplementation alimentServiceImplementation;
    private final GramajServiceImplementation gramajServiceImplementation;
    private final CosAlimentGramajServiceImplementation cosAlimentGramajServiceImplementation;

    @PostMapping("/Insert")
    public ResponseEntity<Object> createMeal(@RequestBody MealAux snackAux) {
        List<Aliment> aliments = new ArrayList<>();
        int i = 0;
        if (snackAux.getAlimentNames() == null)
        {
            return ResponseEntity.badRequest().body("Nu ai introdus alimentele");
        }
        else if (snackAux.getName() == null)
        {
            return ResponseEntity.badRequest().body("Nu ai introdus numele");
        }
        for (String alimentName : snackAux.getAlimentNames()) {
            Aliment aliment = alimentServiceImplementation.findFirstByName(alimentName);
            if (aliment != null) {
                if(snackAux.getGramaje() == null)
                {
                    return ResponseEntity.badRequest().body("Nu ai introdus gramajele");
                }
                Gramaj gramaj = new Gramaj(snackAux.getGramaje().get(i));
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
            calories = calories + aliment.getCaloriesPer100g() * snackAux.getGramaje().get(i)/100;
            i++;
        }
        Snack snack = new Snack(snackAux.getName(), aliments, calories);
        snackServiceImplementation.Insert(snack);
        System.out.println(snackAux);
        return ResponseEntity.ok("Gustarea a fost introdusa");
    }
    /*
    @PostMapping("/GetById")
    public ResponseEntity ReadByID(@RequestBody Integer id){
        Breakfast breakfast = breakfastServiceImplementation.ReadById(id);
        return ResponseEntity.status(HttpStatus.OK).body(breakfast);
    }

     */
}
