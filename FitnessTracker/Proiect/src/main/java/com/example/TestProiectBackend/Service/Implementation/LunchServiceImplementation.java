package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.*;
import com.example.TestProiectBackend.Repository.LunchRepository;
import com.example.TestProiectBackend.Service.LunchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LunchServiceImplementation implements LunchService {
    private final LunchRepository lunchRepository;


    @Override
    public void Insert(Lunch lunch) {
        lunchRepository.save(lunch);
    }

    @Override
    public Lunch findFirstByName(String name){
        return lunchRepository.findFirstByName(name);
    }
    @Override
    public Lunch findFirstByCaloriesIsLessThan(Integer calories)
    {
        return lunchRepository.findFirstByCaloriesIsLessThan(calories);
    }

    @Override
    public Lunch findFirstByCaloriesIsGreaterThan(Integer calories)
    {
        return lunchRepository.findFirstByCaloriesIsGreaterThan(calories);
    }


    /*
    @Override
    public List<Aliment> findAllByHigh(String high) {
        return null;
    }
     */
    @Override
    public String Save(Lunch lunch) {
        if(lunch.getName().isEmpty()){
            //System.out.println("Date insuficiente");
            return ("Name and price fields are required / Select a product");
        }
        else{
            lunchRepository.save(lunch);
            return ("Infos updated succesfully");
            //System.out.println(employee);
        }
    }

    @Override
    public String Delete(Lunch lunch)
    {
        if(lunch.getName().isEmpty()) {
            return ("Lunch needed to be deleted");
        }
        else{
            lunchRepository.delete(lunch);
            return ("Lunch deleted succesfully");
        }
    }

    @Override
    public Lunch findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(Integer calories1, Integer calories2)
    {
        return lunchRepository.findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(calories1, calories2);
    }
}
