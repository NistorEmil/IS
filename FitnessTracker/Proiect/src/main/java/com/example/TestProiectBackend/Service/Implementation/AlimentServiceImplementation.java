package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Workout;
import com.example.TestProiectBackend.Repository.AlimentRepository;
import com.example.TestProiectBackend.Service.AlimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlimentServiceImplementation implements AlimentService {
    private final AlimentRepository alimentRepository;
    //@Autowired
    //private AlimentRepository alimentRepository;

    @Override
    public Aliment findFirstById(Integer id){
        return alimentRepository.findFirstById(id);
    }

    @Override
    public void Insert(Aliment aliment) {
        alimentRepository.save(aliment);
    }
    @Override
    public Aliment findFirstByName(String name)
    {
        return alimentRepository.findFirstByName(name);
    }

    @Override
    public Aliment ReadById(Integer id) {
        Aliment aliment = alimentRepository.findFirstById(id);
        return aliment;
    }

    @Override
    public List<Aliment> findAllByIdGreaterThanEqual(Integer id)
    {
        return alimentRepository.findAllByIdGreaterThanEqual(id);
    }

    /*
    @Override
    public List<Aliment> findAllByCalories()
    {
        List<Aliment> aliments = alimentRepository.findAllByCalories();
        return aliments;
    }

    @Override
    public List<Aliment> findAllByFat()
    {
        List<Aliment> aliments = alimentRepository.findAllByFat();
        return aliments;
    }

    @Override
    public List<Aliment> findAllByProtein()
    {
        List<Aliment> aliments = alimentRepository.findAllByProtein();
        return aliments;
    }
    */
    @Override
    public List<Aliment> findAllByHigh(String high)
    {
        List<Aliment> aliments = alimentRepository.findAllByHigh(high);
        return aliments;
    }

    @Override
    public List<Aliment> findAllByLow(String low)
    {
        List<Aliment> aliments = alimentRepository.findAllByLow(low);
        return aliments;
    }

    public List<Aliment> alimentsToEat(String ojective)
    {
        List<Aliment> aliments1;
        List<Aliment> aliments2;
        if(ojective.equals("weight loss"))
        {
            aliments1 = findAllByLow("Low Calories");
            aliments2 = findAllByLow("Low Fat");
            List<Aliment> aliments = new ArrayList<>();
            aliments.addAll(aliments1);
            aliments.addAll(aliments2);
            return aliments;
        }
        else if(ojective.equals("muscle grow"))
        {
            aliments1 = findAllByHigh("High Protein");
            return aliments1;
        }
        else
        {
            aliments1 = findAllByHigh("High Protein");
            return aliments1;
        }
    }
}
