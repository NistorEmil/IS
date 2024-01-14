package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CosPersonMasaService {
    CosPersonMasa findFirstById(Integer id);
    public void Insert(CosPersonMasa cos);

    public List<CosPersonMasa> getAllCosuri();

    public List<Breakfast> getAllBreakfastsByPersonId(Integer id);
    public List<Snack> getAllSnacksByPersonId(Integer id);
    public List<Dinner> getAllDinnersByPersonId(Integer id);
    public List<Lunch> getAllLunchesByPersonId(Integer id);
    String deleteByBreakfastIdAndPersonId(String breakfastId, Integer personId);
    String deleteByDinnerIdAndPersonId(String dinnerId, Integer personId);
    String deleteBySnackIdAndPersonId(String snackId, Integer personId);
    String deleteByLunchIdAndPersonId(String lunchId, Integer personId);
    String deleteByIdAndPersonId(Integer id, Integer personId);

}