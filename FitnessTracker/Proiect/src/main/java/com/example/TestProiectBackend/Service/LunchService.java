package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.Lunch;
import com.example.TestProiectBackend.Model.Aliment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LunchService {
    public void Insert(Lunch lunch);
    Lunch findFirstByCaloriesIsLessThan(Integer calories);
    Lunch findFirstByCaloriesIsGreaterThan(Integer calories);
    public Lunch findFirstByName(String name);
    //List<Aliment> findAllByHigh(String high);

}