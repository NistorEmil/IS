package com.example.TestProiectBackend.Factory;

import com.example.TestProiectBackend.DTO.MealAux;
import org.springframework.http.ResponseEntity;

public interface MealFactory {
    ResponseEntity<Object> createMeal(MealAux mealAux);
}
