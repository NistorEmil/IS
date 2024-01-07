package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonService {

    Person findFirstById(Integer id);

    void Insert(Person person);
    /*
    Person ReadById(Integer id);


     */
    Double computeCalories(Person person);

}
