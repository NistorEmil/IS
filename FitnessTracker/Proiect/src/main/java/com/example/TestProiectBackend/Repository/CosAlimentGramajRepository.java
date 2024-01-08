package com.example.TestProiectBackend.Repository;
import com.example.TestProiectBackend.Model.CosAlimentGramaj;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CosAlimentGramajRepository extends CrudRepository<CosAlimentGramaj, Integer> {
    CosAlimentGramaj findFirstById(Integer id);
    Iterable<CosAlimentGramaj> findAllByAlimentId(Integer id);

    // in repouri pun doar cele care nu sunt default
    // save, update(aceeasi chestie cu update), delete, find all sunt default
}