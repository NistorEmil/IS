package com.example.TestProiectBackend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dinner implements Meal{
    @Id
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinTable(
            name = "dinner_aliment",
            joinColumns = @JoinColumn(name = "dinner_id"),
            inverseJoinColumns = @JoinColumn(name = "aliment_id"))
    @JsonIgnore
    private List<Aliment> aliments;
    private Integer calories;
    private String day;

    public void setAliments(List<Aliment> aliments) {
        this.aliments = aliments;
    }

    @Override
    public String toString() {
        return "Dinner{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }

    public Dinner(String name, List<Aliment> aliments, Integer calories) {
        this.name = name;
        this.aliments = aliments;
        this.calories = calories;
    }

    @OneToMany
    private List<CosPersonMasa> cosuri;
}