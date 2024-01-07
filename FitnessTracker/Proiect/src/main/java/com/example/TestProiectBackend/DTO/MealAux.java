package com.example.TestProiectBackend.DTO;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class MealAux {

    private Integer id;
    private String name;
    private List<String> alimentNames;
    private List<Integer> gramaje;

    public Integer getId() {
        return id;
    }

    public List<String> getAlimentNames() {
        return alimentNames;
    }

    public List<Integer> getGramaje() {
        return gramaje;
    }
}
