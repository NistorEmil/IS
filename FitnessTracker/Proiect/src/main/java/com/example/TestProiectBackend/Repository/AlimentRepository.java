package com.example.TestProiectBackend.Repository;

import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Workout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentRepository extends CrudRepository<Aliment, Integer> {
    Aliment findFirstById(Integer id);
    Aliment findFirstByName(String name);
    List<Aliment> findAllByIdGreaterThanEqual(Integer id);
    List<Aliment> findAllByName(String nume);
    List<Aliment> findAllByIdAfter(Integer id);

    //List<Aliment> findAllByCalories();

    //List<Aliment> findAllByFat();
    //List<Aliment> findAllByProtein();

    public List<Aliment> findAllByHigh(String high);

    public List<Aliment> findAllByLow(String low);
    public void deleteByName(String alimentName);

    // in repouri pun doar cele care nu sunt default
    // save, update(aceeasi chestie cu update), delete, find all sunt default
}
