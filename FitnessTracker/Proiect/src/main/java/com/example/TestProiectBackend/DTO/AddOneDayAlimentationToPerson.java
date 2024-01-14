package com.example.TestProiectBackend.DTO;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class AddOneDayAlimentationToPerson {
    private Integer personId;
    private String breakfastName;
    private String lunchName;
    private String dinnerName;
    private String snackName;
    private String day;
}