package com.example.TestProiectBackend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Gramaj {
    @Id
    private Integer gramaj;
    @OneToMany
    private List<CosAlimentGramaj> cosuri;

    public Gramaj(Integer gramaj) {
        this.gramaj = gramaj;
    }
}
