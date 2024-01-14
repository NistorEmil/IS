package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Breakfast;
import com.example.TestProiectBackend.Model.Dinner;
import com.example.TestProiectBackend.Model.Workout;
import com.example.TestProiectBackend.Repository.BreakfastRepository;
import com.example.TestProiectBackend.Service.BreakfastService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BreakfastServiceImplementation implements BreakfastService {
    private final BreakfastRepository breakfastRepository;


    @Override
    public String Insert(Breakfast breakfast) {

        if(breakfast.getName().isEmpty() || breakfast.getAliments().isEmpty()){
            return ("All fields are required");
        }
        else {
            breakfastRepository.save(breakfast);
            System.out.println(breakfast);
            return ("Breakfast added succesfully");
        }
    }

    @Override
    public Breakfast findFirstByName(String name){
        return breakfastRepository.findFirstByName(name);
    }
    @Override
    public Breakfast findFirstByCaloriesIsLessThan(Integer calories)
    {
        return breakfastRepository.findFirstByCaloriesIsLessThan(calories);
    }

    @Override
    public Breakfast findFirstByCaloriesIsGreaterThan(Integer calories)
    {
        return breakfastRepository.findFirstByCaloriesIsGreaterThan(calories);
    }

    @Override
    public Breakfast findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(Integer calories1, Integer calories2)
    {
        return breakfastRepository.findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(calories1, calories2);
    }
    @Override
    public String Save(Breakfast breakfast) {
        if(breakfast.getName().isEmpty()){
            //System.out.println("Date insuficiente");
            return ("Name and price fields are required / Select a product");
        }
        else{
            breakfastRepository.save(breakfast);
            return ("Infos updated succesfully");
            //System.out.println(employee);
        }
    }

    @Override
    public String Delete(Breakfast breakfast)
    {
        if(breakfast.getName().isEmpty()) {
            return ("Breakfast needed to be deleted");
        }
        else{
            breakfastRepository.delete(breakfast);
            return ("Breakfast deleted succesfully");
        }
    }

    /*
    @Override
    public List<Aliment> findAllByHigh(String high) {
        return null;
    }
     */
}
