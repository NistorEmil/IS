package com.example.TestProiectBackend.Service;

import com.example.TestProiectBackend.Model.RecomendedAliments;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecomendedAlimentsService {
    RecomendedAliments findFirstById(Integer id);

    public void Insert(RecomendedAliments recomendedAliments);
}

