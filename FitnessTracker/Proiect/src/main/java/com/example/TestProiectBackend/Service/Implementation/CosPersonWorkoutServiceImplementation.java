package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.CosPersonMasa;
import com.example.TestProiectBackend.Model.Workout;
import com.example.TestProiectBackend.Model.CosPersonWorkout;
import com.example.TestProiectBackend.Repository.CosPersonWorkoutRepository;
import com.example.TestProiectBackend.Service.CosPersonWorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CosPersonWorkoutServiceImplementation implements CosPersonWorkoutService {
    private final CosPersonWorkoutRepository cosRepository;
    private final WorkoutServiceImplementation workoutServiceImplementation;
    //@Autowired
    //private EmployeeRepository employeeRepository;

    @Override
    public CosPersonWorkout findFirstById(Integer id){
        return cosRepository.findFirstById(id);
    }

    @Override
    public void Insert(CosPersonWorkout cos) {
        cosRepository.save(cos);
        System.out.println(cos);
    }

    @Override
    public List<CosPersonWorkout> getAllCosuri() {
        return (List<CosPersonWorkout>) cosRepository.findAll();
    }

    @Override
    public List<Workout> getAllWorkoutsByPersonId(Integer id){
        List<CosPersonWorkout> cosuri = (List<CosPersonWorkout>) cosRepository.findAllByPersonId(id);
        ArrayList<Workout> workouts = new ArrayList<>();
        for(CosPersonWorkout cos : cosuri){
            Workout workout = workoutServiceImplementation.findFirstByName(cos.getWorkoutId());
            workouts.add(workout);
        }
        return workouts;
    }

    @Override
    public String deleteById(Integer id)
    {
        if(id == null) {
            return ("Deleted failed");
        }
        else{
            CosPersonWorkout cosPersonMasa = cosRepository.findFirstById(id);
            if (cosPersonMasa != null) {
                cosRepository.deleteById(id);
                return ("Workout deleted succesfully");
            }
            else
            {
                return ("Workout nu exista");
            }
        }
    }

}

