package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.Breakfast;
import com.example.TestProiectBackend.Model.Aliment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BreakfastService {
    String Insert(Breakfast breakfast);
    Breakfast findFirstByCaloriesIsLessThan(Integer calories);
    Breakfast findFirstByCaloriesIsGreaterThan(Integer calories);
    public Breakfast findFirstByName(String name);
    public String Save(Breakfast breakfast);
    public String Delete(Breakfast breakfast);
    Breakfast findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(Integer calories1, Integer calories2);
    //List<Aliment> findAllByHigh(String high);

}