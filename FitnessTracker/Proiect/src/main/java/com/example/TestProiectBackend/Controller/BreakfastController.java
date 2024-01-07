/*
package com.example.TestProiectBackend.Controller;

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

public class BreakfastController {

    private final BreakfastServiceImplementation breakfastServiceImplementation;
    private final AlimentServiceImplementation alimentServiceImplementation;
    /*
    @PostMapping("/Insert")
    public void insert(@RequestBody MealAux breakfastAux){
        Breakfast breakfast = new Breakfast();
        breakfast.setId(breakfastAux.getId());
        List<Aliment> aliments = new ArrayList<>();
        for(String alimentName: breakfastAux.getAlimentNames())
        {
            aliments.add(alimentServiceImplementation.findFirstByName(alimentName));
        }
        breakfast.setAliments(aliments);
        breakfastServiceImplementation.Insert(breakfast);
        System.out.println(breakfast);
    }
    */
    /*
    @PostMapping("/GetById")
    public ResponseEntity ReadByID(@RequestBody Integer id){
        Breakfast breakfast = breakfastServiceImplementation.ReadById(id);
        return ResponseEntity.status(HttpStatus.OK).body(breakfast);
    }


}
*/