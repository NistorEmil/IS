package com.example.TestProiectBackend.Repository;
import com.example.TestProiectBackend.Model.CosPersonMasa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CosPersonMasaRepository extends CrudRepository<CosPersonMasa, Integer> {
    CosPersonMasa findFirstById(Integer id);

    Iterable<CosPersonMasa> findAllByPersonId(Integer id);

    // in repouri pun doar cele care nu sunt default
    // save, update(aceeasi chestie cu update), delete, find all sunt default
}