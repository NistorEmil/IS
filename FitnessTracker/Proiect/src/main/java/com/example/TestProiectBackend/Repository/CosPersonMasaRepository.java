package com.example.TestProiectBackend.Repository;
import com.example.TestProiectBackend.Model.CosPersonMasa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CosPersonMasaRepository extends CrudRepository<CosPersonMasa, Integer> {
    CosPersonMasa findFirstById(Integer id);

    List<CosPersonMasa> findAllByPersonId(Integer id);

    void deleteByBreakfastIdAndPersonId(String breakfastId, Integer personId);
    void deleteByDinnerIdAndPersonId(String dinnerId, Integer personId);
    void deleteBySnackIdAndPersonId(String snackId, Integer personId);
    void deleteByLunchIdAndPersonId(String lunchId, Integer personId);
    void deleteByIdAndPersonId(Integer id, Integer personId);

    // in repouri pun doar cele care nu sunt default
    // save, update(aceeasi chestie cu update), delete, find all sunt default
}