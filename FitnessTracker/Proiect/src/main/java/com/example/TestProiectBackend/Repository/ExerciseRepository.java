package com.example.TestProiectBackend.Repository;

import com.example.TestProiectBackend.Model.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {
    Exercise findFirstById(Integer id);
    Exercise findFirstByName(String name);
    List<Exercise> findAllByName(String nume);
    List<Exercise> findAllByNameAfter(String name);

}
