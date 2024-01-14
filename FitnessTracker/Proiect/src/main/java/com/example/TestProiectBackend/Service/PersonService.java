package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonService {

    Person findFirstById(Integer id);

    String Insert(Person person);
    Person findFirstByName(String name);
    public String Save(Person person);
    public String Delete(Person person);
    public List<Person> getAllPersons();
    /*
    Person ReadById(Integer id);


     */
    Double computeCalories(Person person);
    List<Person> findAllByIdGreaterThanEqual(Integer id);

}
