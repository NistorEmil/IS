package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.Breakfast;
import com.example.TestProiectBackend.Model.Aliment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BreakfastService {
    public void Insert(Breakfast breakfast);
    Breakfast findFirstByCaloriesIsLessThan(Integer calories);
    Breakfast findFirstByCaloriesIsGreaterThan(Integer calories);
    public Breakfast findFirstByName(String name);
    //List<Aliment> findAllByHigh(String high);

}