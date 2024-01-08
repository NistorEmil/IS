package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.Breakfast;
import com.example.TestProiectBackend.Model.CosPersonMasa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CosPersonMasaService {
    CosPersonMasa findFirstById(Integer id);
    public void Insert(CosPersonMasa cos);

    public List<CosPersonMasa> getAllCosuri();

    public List<Breakfast> getAllBreakfastsByPersonId(Integer id);

}