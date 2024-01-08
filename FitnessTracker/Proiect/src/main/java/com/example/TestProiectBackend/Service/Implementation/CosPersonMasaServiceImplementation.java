package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Breakfast;
import com.example.TestProiectBackend.Model.CosPersonMasa;
import com.example.TestProiectBackend.Repository.CosPersonMasaRepository;
import com.example.TestProiectBackend.Service.CosPersonMasaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CosPersonMasaServiceImplementation implements CosPersonMasaService {
    private final CosPersonMasaRepository cosRepository;
    private final BreakfastServiceImplementation breakfastServiceImplementation;
    //@Autowired
    //private EmployeeRepository employeeRepository;

    @Override
    public CosPersonMasa findFirstById(Integer id){
        return cosRepository.findFirstById(id);
    }

    @Override
    public void Insert(CosPersonMasa cos) {
        cosRepository.save(cos);
        System.out.println(cos);
    }

    @Override
    public List<CosPersonMasa> getAllCosuri() {
        return (List<CosPersonMasa>) cosRepository.findAll();
    }

    @Override
    public List<Breakfast> getAllBreakfastsByPersonId(Integer id){
        List<CosPersonMasa> cosuri = (List<CosPersonMasa>) cosRepository.findAllByPersonId(id);
        ArrayList<Breakfast> breakfasts = new ArrayList<>();
        for(CosPersonMasa cos : cosuri){
            Breakfast breakfast = breakfastServiceImplementation.findFirstByName(cos.getBreakfastId());
            breakfasts.add(breakfast);
        }
        return breakfasts;
    }

}

