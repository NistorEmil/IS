package com.example.TestProiectBackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties("personList")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String gender;
    private String name;
    private Integer age;
    private Double weight;
    private Integer height;
    private Integer numberOfTrainingDays;
    private String activeMetabolicRate;
    private String objective;
    /*
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinTable(
            name = "person_breakfast",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "breakfast_id"))
    @JsonIgnore
    private List<Breakfast> breakfastList = new ArrayList<>(7);

     */

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", numberOfTrainingDays=" + numberOfTrainingDays +
                ", activeMetabolicRate='" + activeMetabolicRate + '\'' +
                ", objective='" + objective + '\'' +
                '}';
    }

    @OneToMany
    private List<CosPersonMasa> cosuri;
    @OneToMany
    private List<CosPersonWorkout> cosPersonWorkouts;
}
