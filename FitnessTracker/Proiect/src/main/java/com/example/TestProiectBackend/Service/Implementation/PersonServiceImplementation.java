package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Person;
import com.example.TestProiectBackend.Repository.PersonRepository;
import com.example.TestProiectBackend.Service.PersonService;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImplementation implements PersonService {
    private final PersonRepository personRepository;
    //@Autowired
    //private PersonRepository personRepository;


    @Override
    public Person findFirstById(Integer id){
        return personRepository.findFirstById(id);
    }

    @Override
    public void Insert(Person person) {
        personRepository.save(person);
    }
 /*
    @Override
    public Person ReadById(Integer id) {
        Person person = personRepository.findFirstById(id);
        return person;
    }

     */

    @Override
    public Double computeCalories(Person person)
    {
        Double BMR = 0.0;
        Double AMR = 0.0;
        if(person.getGender().equals("male"))
        {
            BMR = 655.1 + (9.563 * person.getWeight()) + (1.850 * person.getHeight()) - (4.676 * person.getAge());
            if(person.getActiveMetabolicRate().equals("sedentary(little or no exercise)"))
            {
                AMR = BMR * 1.2;
            }
            else if(person.getActiveMetabolicRate().equals("lightly active(exercise 1-3 days/week)"))
            {
                AMR = BMR * 1.375;
            }
            else if(person.getActiveMetabolicRate().equals("moderately active(exercise 3-5 days/week)"))
            {
                AMR = BMR * 1.55;
            }
            else if(person.getActiveMetabolicRate().equals("active(exercise 6-7 days/week)"))
            {
                AMR = BMR * 1.725;
            }
            else if(person.getActiveMetabolicRate().equals("very active(hard exercise 6-7 days/week)"))
            {
                AMR = BMR * 1.9;
            }
        }
        else
        {
            BMR = 66.47 + (13.75 * person.getWeight()) + (5.003 * person.getHeight()) - (6.755 * person.getAge());
            if(person.getActiveMetabolicRate().equals("sedentary(little or no exercise)"))
            {
                AMR = BMR * 1.2;
            }
            else if(person.getActiveMetabolicRate().equals("lightly active(exercise 1-3 days/week)"))
            {
                AMR = BMR * 1.375;
            }
            else if(person.getActiveMetabolicRate().equals("moderately active(exercise 3-5 days/week)"))
            {
                AMR = BMR * 1.55;
            }
            else if(person.getActiveMetabolicRate().equals("active(exercise 6-7 days/week)"))
            {
                AMR = BMR * 1.725;
            }
            else if(person.getActiveMetabolicRate().equals("very active(hard exercise 6-7 days/week)"))
            {
                AMR = BMR * 1.9;
            }
        }
        System.out.println(AMR);
        return AMR;
    }

}
