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
public class Lunch implements Meal{
    @Id
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinTable(
            name = "lunch_aliment",
            joinColumns = @JoinColumn(name = "lunch_id"),
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
        return "Lunch{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }

    public Lunch(String name, List<Aliment> aliments, Integer calories) {
        this.name = name;
        this.aliments = aliments;
        this.calories = calories;
    }

    @OneToMany
    private List<CosPersonMasa> cosuri;
}
