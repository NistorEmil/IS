package com.example.TestProiectBackend.Repository;

import com.example.TestProiectBackend.Model.WorkoutPlan;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutPlanRepository extends CrudRepository<WorkoutPlan, Integer> {
    WorkoutPlan findFirstById(Integer id);
    List<WorkoutPlan> findAllById(Integer id);
    List<WorkoutPlan> findAllByIdAfter(Integer id);

}
