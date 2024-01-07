package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Breakfast;
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
    public void Insert(Breakfast breakfast) {
        breakfastRepository.save(breakfast);
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


    /*
    @Override
    public List<Aliment> findAllByHigh(String high) {
        return null;
    }
     */
}
