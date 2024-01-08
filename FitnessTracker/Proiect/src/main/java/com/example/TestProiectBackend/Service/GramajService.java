package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.Gramaj;

public interface GramajService {
    public String Insert(Gramaj gramaj);

    Gramaj findFirstById(Integer id);
}
