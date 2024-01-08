package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Breakfast;
import com.example.TestProiectBackend.Model.Workout;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AlimentService {
    Aliment findFirstById(Integer id);
    Aliment findFirstByName(String name);
    List<Aliment> findAllByIdGreaterThanEqual(Integer id);

    public String Insert(Aliment aliment);

    public Aliment ReadById(Integer id);
    public String Delete(Aliment aliment);
    public String DeleteByName(String alimentName);

    /*
    List<Aliment> findAllByCalories();

    List<Aliment> findAllByFat();

    List<Aliment> findAllByProtein();

     */

    List<Aliment> findAllByHigh(String high);

    List<Aliment> findAllByLow(String low);
    public String Save(Aliment aliment);
}
