package com.example.TestProiectBackend.Repository;

import com.example.TestProiectBackend.Model.RecomendedAliments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecomendedAlimentsRepository extends CrudRepository<RecomendedAliments, Integer> {
    RecomendedAliments findFirstById(Integer id);

}
