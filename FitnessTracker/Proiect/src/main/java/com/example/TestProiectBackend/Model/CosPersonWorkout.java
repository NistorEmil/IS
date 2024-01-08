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
public class CosPersonWorkout{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer personId;
    private String workoutId;

    public CosPersonWorkout(Integer personId, String workoutId) {
        this.personId = personId;
        this.workoutId = workoutId;
    }
}
