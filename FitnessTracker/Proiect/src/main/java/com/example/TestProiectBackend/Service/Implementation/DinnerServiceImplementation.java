package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Breakfast;
import com.example.TestProiectBackend.Model.Dinner;
import com.example.TestProiectBackend.Model.Workout;
import com.example.TestProiectBackend.Repository.DinnerRepository;
import com.example.TestProiectBackend.Service.DinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DinnerServiceImplementation implements DinnerService {
    private final DinnerRepository dinnerRepository;


    @Override
    public void Insert(Dinner dinner) {
        dinnerRepository.save(dinner);
    }

    @Override
    public Dinner findFirstByName(String name){
        return dinnerRepository.findFirstByName(name);
    }
    @Override
    public Dinner findFirstByCaloriesIsLessThan(Integer calories)
    {
        return dinnerRepository.findFirstByCaloriesIsLessThan(calories);
    }

    @Override
    public Dinner findFirstByCaloriesIsGreaterThan(Integer calories)
    {
        return dinnerRepository.findFirstByCaloriesIsGreaterThan(calories);
    }


    /*
    @Override
    public List<Aliment> findAllByHigh(String high) {
        return null;
    }
     */
    public String Save(Dinner dinner) {
        if(dinner.getName().isEmpty()){
            //System.out.println("Date insuficiente");
            return ("Name and price fields are required / Select a product");
        }
        else{
            dinnerRepository.save(dinner);
            return ("Infos updated succesfully");
            //System.out.println(employee);
        }
    }
}
