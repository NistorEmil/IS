package com.example.TestProiectBackend.Repository;

import com.example.TestProiectBackend.Model.Workout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Integer> {
    Workout findFirstByName(String name);
    List<Workout> findAllByName(String nume);
    List<Workout> findAllByNameAfter(String name);

}
