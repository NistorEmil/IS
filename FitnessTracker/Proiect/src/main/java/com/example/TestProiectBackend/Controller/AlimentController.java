package com.example.TestProiectBackend.Controller;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Service.Implementation.AlimentServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Aliment")
@RequiredArgsConstructor

public class AlimentController {

    private final AlimentServiceImplementation alimentServiceImplementation;

    @PostMapping("/Insert")
    public void insert(@RequestBody Aliment aliment){
        alimentServiceImplementation.Insert(aliment);
        System.out.println(aliment);
    }

    @PostMapping("/GetById")
    public ResponseEntity ReadByID(@RequestBody Integer id){
        Aliment aliment = alimentServiceImplementation.ReadById(id);
        return ResponseEntity.status(HttpStatus.OK).body(aliment); // ce pun in parantezele de la body primesc in front end
        //HttpStatus.BAD_REQUEST pt erori
    }

    @PostMapping("/findAll")
    public void find(){
        List<Aliment> aliments = alimentServiceImplementation.findAllByIdGreaterThanEqual(0);
        for(Aliment aliment:aliments)
        {
            System.out.println(aliment);
        }
    }

}