package com.example.TestProiectBackend.Factory;

import com.example.TestProiectBackend.DTO.MealAux;
import com.example.TestProiectBackend.Model.Aliment;
import com.example.TestProiectBackend.Model.Meal;

import java.util.List;

public interface MealFactory {
    void createMeal(MealAux mealAux);
}
