package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Gramaj;
import com.example.TestProiectBackend.Model.Person;
import com.example.TestProiectBackend.Repository.GramajRepository;
import com.example.TestProiectBackend.Service.GramajService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GramajServiceImplementation implements GramajService {
    private final GramajRepository gramajRepository;


    @Override
    public String Insert(Gramaj gramaj) {
        if(gramaj.getGramaj() == null){
            return ("All fields are required");
        }
        else
        {
            gramajRepository.save(gramaj);
            System.out.println(gramaj);
            return ("Gramaj added succesfully");
        }
    }

    @Override
    public Gramaj findFirstById(Integer id){
        return gramajRepository.findFirstByGramaj(id);
    }


    public String Save(Gramaj gramaj) {
        if(gramaj.getGramaj() == null){
            return ("Gramaj fields is required");
        }
        else{
            gramajRepository.save(gramaj);
            return ("Infos updated succesfully");
            //System.out.println(employee);
        }
    }
}
