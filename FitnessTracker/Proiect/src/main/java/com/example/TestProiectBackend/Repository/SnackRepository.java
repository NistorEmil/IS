package com.example.TestProiectBackend.Repository;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Breakfast;
import com.example.TestProiectBackend.Model.Snack;
import com.example.TestProiectBackend.Model.Workout;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SnackRepository extends CrudRepository<Snack, Integer> {
    Snack findFirstByCaloriesIsLessThan(Integer calories);
    Snack findFirstByCaloriesIsGreaterThan(Integer calories);
    Snack findFirstByName(String name);
    Snack findFirstByCaloriesIsGreaterThanAndCaloriesIsLessThan(Integer calories1, Integer calories2);
    //public List<Aliment> findAllByHigh(String high);
}