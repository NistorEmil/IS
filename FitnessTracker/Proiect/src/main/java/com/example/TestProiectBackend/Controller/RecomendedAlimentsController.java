package com.example.TestProiectBackend.Controller;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Person;
import com.example.TestProiectBackend.Model.RecomendedAliments;
import com.example.TestProiectBackend.Service.Implementation.AlimentServiceImplementation;
import com.example.TestProiectBackend.Service.Implementation.PersonServiceImplementation;
import com.example.TestProiectBackend.Service.Implementation.RecomendedAlimentsServiceImplementation;
import com.example.TestProiectBackend.Service.RecomendedAlimentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/RecomendedAliments")
@RequiredArgsConstructor

public class RecomendedAlimentsController {

    private final RecomendedAlimentsServiceImplementation recomendedAlimentsServiceImplementation;


    @PostMapping("/Insert")
    public void insert(@RequestBody RecomendedAliments recomendedAliments){
        recomendedAlimentsServiceImplementation.Insert(recomendedAliments);
        System.out.println(recomendedAliments);
    }

    @PostMapping("/Alimentation")
    public void alimentation(@RequestBody Person person)
    {
        System.out.println("\nAlimente recomandate:\n");
        RecomendedAliments recomendedAliment= recomendedAlimentsServiceImplementation.alimentation(person);
        for(Aliment aliment: recomendedAliment.getAliments())
        {
            System.out.println(aliment.getName());
        }
        System.out.println("Calories : " + recomendedAliment.getCalories());
        System.out.println(recomendedAliment.getRecomandation());
    }


}
