package com.example.TestProiectBackend.Repository;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Dinner;
import com.example.TestProiectBackend.Model.Workout;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DinnerRepository extends CrudRepository<Dinner, Integer> {
    Dinner findFirstByCaloriesIsLessThan(Integer calories);
    Dinner findFirstByCaloriesIsGreaterThan(Integer calories);
    Dinner findFirstByName(String name);
    //public List<Aliment> findAllByHigh(String high);
}
