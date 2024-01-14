package com.example.TestProiectBackend.Repository;
import com.example.TestProiectBackend.Model.CosPersonWorkout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CosPersonWorkoutRepository extends CrudRepository<CosPersonWorkout, Integer> {
    CosPersonWorkout findFirstById(Integer id);

    Iterable<CosPersonWorkout> findAllByPersonId(Integer id);

    void deleteById(Integer id);

    // in repouri pun doar cele care nu sunt default
    // save, update(aceeasi chestie cu update), delete, find all sunt default
}