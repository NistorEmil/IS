package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Person;
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
    public String Insert(Aliment aliment) {
        if(aliment.getName().isEmpty() || aliment.getCaloriesPer100g() == null || aliment.getProtein() == null || aliment.getFat() == null || aliment.getCarbs() == null || aliment.getFibre() == null){
            return ("All fields are required");
        }
        else
        {
            alimentRepository.save(aliment);
            System.out.println(aliment);
            return ("Aliment added succesfully");
        }
    }

    @Override
    public String Delete(Aliment aliment){
        if(aliment.getName().isEmpty()) {
            return ("Aliment needed to be deleted");
        }
        else{
            alimentRepository.delete(aliment);
            return ("Aliment deleted succesfully");
        }
    }

    @Override
    public String DeleteByName(String alimentName)
    {
        if(alimentName.isEmpty()) {
            return ("Aliment needed to be deleted");
        }
        else{
            alimentRepository.deleteByName(alimentName);
            return ("Aliment deleted succesfully");
        }
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

    @Override
    public String Save(Aliment aliment) {
        if(aliment.getName().isEmpty()){
            //System.out.println("Date insuficiente");
            return ("Name and price fields are required / Select a product");
        }
        else{
            alimentRepository.save(aliment);
            return ("Infos updated succesfully");
            //System.out.println(employee);
        }
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
