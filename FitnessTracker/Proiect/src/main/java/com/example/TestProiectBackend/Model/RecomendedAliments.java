package com.example.TestProiectBackend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class RecomendedAliments {
    @Id
    private Integer id;
    @OneToMany
    private List<Aliment> aliments;
    private Double calories;
    private String recomandation;
}
