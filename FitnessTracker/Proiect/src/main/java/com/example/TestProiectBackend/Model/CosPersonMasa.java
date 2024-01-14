package com.example.TestProiectBackend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CosPersonMasa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer personId;
    private String breakfastId;
    private String lunchId;
    private String dinnerId;
    private String snackId;

    public CosPersonMasa(Integer personId, String breakfastId, String lunchId, String dinnerId, String snackId) {
        this.personId = personId;
        this.breakfastId = breakfastId;
        this.lunchId = lunchId;
        this.dinnerId = dinnerId;
        this.snackId = snackId;
    }
}
