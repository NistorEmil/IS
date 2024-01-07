package com.example.TestProiectBackend.Repository;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Lunch;
import com.example.TestProiectBackend.Model.Workout;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LunchRepository extends CrudRepository<Lunch, Integer> {
    Lunch findFirstByCaloriesIsLessThan(Integer calories);
    Lunch findFirstByCaloriesIsGreaterThan(Integer calories);
    Lunch findFirstByName(String name);
    //public List<Aliment> findAllByHigh(String high);
}