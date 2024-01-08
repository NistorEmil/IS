package com.example.TestProiectBackend.Repository;
import com.example.TestProiectBackend.Model.Gramaj;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GramajRepository extends CrudRepository<Gramaj, Integer> {
    Gramaj findFirstByGramaj(Integer id);

    // in repouri pun doar cele care nu sunt default
    // save, update(aceeasi chestie cu update), delete, find all sunt default
}