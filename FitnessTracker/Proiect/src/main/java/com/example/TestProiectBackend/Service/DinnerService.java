package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.Breakfast;
import com.example.TestProiectBackend.Model.Dinner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DinnerService {
    public void Insert(Dinner dinner);
    Dinner findFirstByCaloriesIsLessThan(Integer calories);
    Dinner findFirstByCaloriesIsGreaterThan(Integer calories);
    public Dinner findFirstByName(String name);
    //List<Aliment> findAllByHigh(String high);
    public String Save(Dinner dinner);

}
