package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.CosAlimentGramaj;

import java.util.List;

public interface CosAlimentGramajService {
    public List<CosAlimentGramaj> getAllCosuri();
    public void Insert(CosAlimentGramaj cos);
    public CosAlimentGramaj findFirstById(Integer id);
}
