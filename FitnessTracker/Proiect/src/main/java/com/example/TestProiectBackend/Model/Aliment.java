package com.example.TestProiectBackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Aliment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer caloriesPer100g;
    private Double protein;
    private Double fat;
    private Double carbs;
    private Double fibre;
    private String high;
    private String low;
    @ManyToMany(mappedBy = "aliments")
    @JsonIgnore
    private List<Breakfast> breakfasts;
    private Integer gramaj;
}
