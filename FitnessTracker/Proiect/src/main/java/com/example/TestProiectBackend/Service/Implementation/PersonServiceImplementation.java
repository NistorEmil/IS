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
    public String Insert(Person person) {
        if(person.getGender().isEmpty() || person.getName().isEmpty() || person.getAge() == null || person.getWeight() == null || person.getHeight() == null || person.getNumberOfTrainingDays() == null || person.getActiveMetabolicRate() == null || person.getObjective().isEmpty()){
            return ("All fields are required");
        }
        else
        {
            personRepository.save(person);
            System.out.println(person);
            return ("Person added succesfully");
        }
    }

    @Override
    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person findFirstByName(String name) {
        return personRepository.findFirstByName(name);
    }

    @Override
    public String Delete(Person person){
        if(person.getName().isEmpty()) {
            return ("Person needed to be deleted");
        }
        else{
            personRepository.delete(person);
            return ("Person deleted succesfully");
        }
    }

    public String Save(Person person) {
        System.out.println(person.getId());
        System.out.println(person.getAge());
        System.out.println(person.getName());
        if(person.getGender().isEmpty() || person.getName().isEmpty() || person.getAge() == null ||  person.getWeight() == null || person.getHeight() == null ||  person.getNumberOfTrainingDays() == null || person.getActiveMetabolicRate().isEmpty() || person.getObjective().isEmpty()){
            //System.out.println("Date insuficiente");
            return ("All fields are required / Select a person");
        }
        else{
            personRepository.save(person);
            return ("Infos updated succesfully");
            //System.out.println(employee);
        }
    }


    @Override
    public List<Person> findAllByIdGreaterThanEqual(Integer id)
    {
        return personRepository.findAllByIdGreaterThanEqual(id);
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
