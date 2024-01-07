package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Person;
import com.example.TestProiectBackend.Model.RecomendedAliments;
import com.example.TestProiectBackend.Repository.RecomendedAlimentsRepository;
import com.example.TestProiectBackend.Service.AlimentService;
import com.example.TestProiectBackend.Service.RecomendedAlimentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecomendedAlimentsServiceImplementation implements RecomendedAlimentsService {
    private final RecomendedAlimentsRepository recomendedAlimentsRepository;

    private final PersonServiceImplementation personServiceImplementation;
    private final AlimentServiceImplementation alimentServiceImplementation;
    //@Autowired
    //private AlimentRepository alimentRepository;

    @Override
    public RecomendedAliments findFirstById(Integer id){
        return recomendedAlimentsRepository.findFirstById(id);
    }

    @Override
    public void Insert(RecomendedAliments recomendedAliments) {
        recomendedAlimentsRepository.save(recomendedAliments);
    }


    public RecomendedAliments alimentation(Person person)
    {
        RecomendedAliments  recomendedAliments = new RecomendedAliments();
        Double calories = personServiceImplementation.computeCalories(person);
        recomendedAliments.setCalories(calories);
        if(person.getObjective().equals("weight loss"))
        {
            recomendedAliments.setRecomandation("Pentru a pierde in greutate este foarte important sa ai un deficit caloric." +
                    "De asemenea pentru a obtine rezultate cat mai bune este la fel de important" +
                    " sa consumi o cantitate mai mica de grasimi si o cantitate mai mare de proteine.");

            recomendedAliments.setAliments(alimentServiceImplementation.alimentsToEat(person.getObjective()));
        }
        return recomendedAliments;
    }

}