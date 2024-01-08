package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Breakfast;
import com.example.TestProiectBackend.Model.CosAlimentGramaj;
import com.example.TestProiectBackend.Repository.CosAlimentGramajRepository;
import com.example.TestProiectBackend.Service.CosAlimentGramajService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CosAlimentGramajServiceImplementation implements CosAlimentGramajService {
    private final CosAlimentGramajRepository cosRepository;

    //@Autowired
    //private EmployeeRepository employeeRepository;

    @Override
    public CosAlimentGramaj findFirstById(Integer id){
        return cosRepository.findFirstById(id);
    }

    @Override
    public void Insert(CosAlimentGramaj cos) {
        cosRepository.save(cos);
        System.out.println(cos);
    }

    @Override
    public List<CosAlimentGramaj> getAllCosuri() {
        return (List<CosAlimentGramaj>) cosRepository.findAll();
    }


}

