package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.*;
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

    @Override
    public String Delete(Snack snack)
    {
        if(snack.getName().isEmpty()) {
            return ("Snack needed to be deleted");
        }
        else{
            snackRepository.delete(snack);
            return ("Snack deleted succesfully");
        }
    }

    @Override
    public String Save(Snack snack) {
        if(snack.getName().isEmpty()){
            //System.out.println("Date insuficiente");
            return ("Name and price fields are required / Select a product");
        }
        else{
            snackRepository.save(snack);
            return ("Infos updated succesfully");
            //System.out.println(employee);
        }
    }
    /*
    @Override
    public List<Aliment> findAllByHigh(String high) {
        return null;
    }
     */
    @Override
    public Snack findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(Integer calories1, Integer calories2)
    {
        return snackRepository.findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(calories1, calories2);
    }
}
