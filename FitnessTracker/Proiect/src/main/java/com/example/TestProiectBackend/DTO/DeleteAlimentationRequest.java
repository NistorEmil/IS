package com.example.TestProiectBackend.DTO;

import com.example.TestProiectBackend.Model.CosPersonMasa;
import com.example.TestProiectBackend.Model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeleteAlimentationRequest {
    private Person person;
    private CosPersonMasa cosPersonMasa;

    // getters and setters
}
