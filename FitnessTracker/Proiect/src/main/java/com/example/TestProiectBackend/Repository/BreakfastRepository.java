package com.example.TestProiectBackend.Repository;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Breakfast;
import com.example.TestProiectBackend.Model.Workout;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreakfastRepository extends CrudRepository<Breakfast, Integer> {
    Breakfast findFirstByCaloriesIsLessThan(Integer calories);
    Breakfast findFirstByCaloriesIsGreaterThan(Integer calories);
    Breakfast findFirstByName(String name);
    //public List<Aliment> findAllByHigh(String high);
}