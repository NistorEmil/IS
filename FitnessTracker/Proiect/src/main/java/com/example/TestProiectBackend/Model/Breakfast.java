package com.example.TestProiectBackend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties("aliments")
public class Breakfast implements Meal{
    @Id
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinTable(
            name = "breakfast_aliment",
            joinColumns = @JoinColumn(name = "breakfast_id"),
            inverseJoinColumns = @JoinColumn(name = "aliment_id"))
    @JsonIgnore
    private List<Aliment> aliments;
    private Integer calories;

    public void setAliments(List<Aliment> aliments) {
        this.aliments = aliments;
    }

    @Override
    public String toString() {
        return "Breakfast{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }

    public Breakfast(String name, List<Aliment> aliments, Integer calories) {
        this.name = name;
        this.aliments = aliments;
        this.calories = calories;
    }

    private String day;
    @ManyToMany(mappedBy = "breakfastList")
    @JsonIgnore
    private List<Person> personList = new ArrayList<>();


}
