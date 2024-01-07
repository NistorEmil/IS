package com.example.TestProiectBackend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

import java.util.List;
import java.util.Map;


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
}
