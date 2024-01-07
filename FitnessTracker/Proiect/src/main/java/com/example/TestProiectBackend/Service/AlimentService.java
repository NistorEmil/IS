package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Workout;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AlimentService {
    Aliment findFirstById(Integer id);
    Aliment findFirstByName(String name);
    List<Aliment> findAllByIdGreaterThanEqual(Integer id);

    public void Insert(Aliment aliment);

    public Aliment ReadById(Integer id);

    /*
    List<Aliment> findAllByCalories();

    List<Aliment> findAllByFat();

    List<Aliment> findAllByProtein();

     */

    List<Aliment> findAllByHigh(String high);

    List<Aliment> findAllByLow(String low);
}
