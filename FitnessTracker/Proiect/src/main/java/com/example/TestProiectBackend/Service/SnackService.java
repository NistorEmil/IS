package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.Snack;
import com.example.TestProiectBackend.Model.Aliment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SnackService {
    public void Insert(Snack snack);
    Snack findFirstByCaloriesIsLessThan(Integer calories);
    Snack findFirstByCaloriesIsGreaterThan(Integer calories);
    public Snack findFirstByName(String name);
    //List<Aliment> findAllByHigh(String high);

}