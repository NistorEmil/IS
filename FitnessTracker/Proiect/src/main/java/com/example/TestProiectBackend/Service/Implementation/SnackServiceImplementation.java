package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Snack;
import com.example.TestProiectBackend.Model.Workout;
import com.example.TestProiectBackend.Repository.SnackRepository;
import com.example.TestProiectBackend.Service.SnackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SnackServiceImplementation implements SnackService {
    private final SnackRepository snackRepository;


    @Override
    public void Insert(Snack snack) {
        snackRepository.save(snack);
    }

    @Override
    public Snack findFirstByName(String name){
        return snackRepository.findFirstByName(name);
    }
    @Override
    public Snack findFirstByCaloriesIsLessThan(Integer calories)
    {
        return snackRepository.findFirstByCaloriesIsLessThan(calories);
    }

    @Override
    public Snack findFirstByCaloriesIsGreaterThan(Integer calories)
    {
        return snackRepository.findFirstByCaloriesIsGreaterThan(calories);
    }


    /*
    @Override
    public List<Aliment> findAllByHigh(String high) {
        return null;
    }
     */
}
