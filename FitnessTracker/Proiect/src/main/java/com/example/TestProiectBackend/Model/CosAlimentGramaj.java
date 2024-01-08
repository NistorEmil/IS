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
public class CosAlimentGramaj{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer alimentId;
    private Integer gramajId;

    public CosAlimentGramaj(Integer alimentId, Integer gramajId) {
        this.alimentId = alimentId;
        this.gramajId = gramajId;
    }
}
