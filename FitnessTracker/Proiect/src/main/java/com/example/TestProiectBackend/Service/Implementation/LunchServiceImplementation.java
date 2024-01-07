package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Lunch;
import com.example.TestProiectBackend.Model.Workout;
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
}
