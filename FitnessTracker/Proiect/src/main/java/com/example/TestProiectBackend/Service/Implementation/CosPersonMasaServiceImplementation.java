package com.example.TestProiectBackend.Service.Implementation;

import com.example.TestProiectBackend.Model.Breakfast;
import com.example.TestProiectBackend.Model.Dinner;
import com.example.TestProiectBackend.Model.Snack;
import com.example.TestProiectBackend.Model.CosPersonMasa;
import com.example.TestProiectBackend.Model.Lunch;
import com.example.TestProiectBackend.Repository.CosPersonMasaRepository;
import com.example.TestProiectBackend.Service.CosPersonMasaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CosPersonMasaServiceImplementation implements CosPersonMasaService {
    private final CosPersonMasaRepository cosRepository;
    private final BreakfastServiceImplementation breakfastServiceImplementation;
    private final LunchServiceImplementation lunchServiceImplementation;
    private final DinnerServiceImplementation dinnerServiceImplementation;
    private final SnackServiceImplementation snackServiceImplementation;
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
        List<CosPersonMasa> cosuri = cosRepository.findAllByPersonId(id);
        List<Breakfast> breakfasts = new ArrayList<>();
        for(CosPersonMasa cos : cosuri){
            Breakfast breakfast = breakfastServiceImplementation.findFirstByName(cos.getBreakfastId());
            breakfasts.add(breakfast);
        }
        return breakfasts;
    }

    @Override
    public List<Lunch> getAllLunchesByPersonId(Integer id){
        List<CosPersonMasa> cosuri = cosRepository.findAllByPersonId(id);
        List<Lunch> lunches = new ArrayList<>();
        for(CosPersonMasa cos : cosuri){
            Lunch lunch = lunchServiceImplementation.findFirstByName(cos.getLunchId());
            lunches.add(lunch);
        }
        return lunches;
    }

    @Override
    public List<Dinner> getAllDinnersByPersonId(Integer id){
        List<CosPersonMasa> cosuri = cosRepository.findAllByPersonId(id);
        List<Dinner> dinners = new ArrayList<>();
        for(CosPersonMasa cos : cosuri){
            Dinner dinner = dinnerServiceImplementation.findFirstByName(cos.getDinnerId());
            dinners.add(dinner);
        }
        return dinners;
    }

    @Override
    public List<Snack> getAllSnacksByPersonId(Integer id){
        List<CosPersonMasa> cosuri = cosRepository.findAllByPersonId(id);
        List<Snack> snacks = new ArrayList<>();
        for(CosPersonMasa cos : cosuri){
            Snack snack = snackServiceImplementation.findFirstByName(cos.getSnackId());
            snacks.add(snack);
        }
        return snacks;
    }

    @Override
    public String deleteByBreakfastIdAndPersonId(String breakfastId, Integer personId)
    {
        if(breakfastId == null || personId == null) {
            return ("Deleted failed");
        }
        else{
            cosRepository.deleteByBreakfastIdAndPersonId(breakfastId, personId);
            return ("Breakfast deleted succesfully");
        }
    }

    @Override
    public String deleteByDinnerIdAndPersonId(String dinnerId, Integer personId)
    {
        if(dinnerId == null || personId == null) {
            return ("Deleted failed");
        }
        else{
            cosRepository.deleteByDinnerIdAndPersonId(dinnerId, personId);
            return ("Dinner deleted succesfully");
        }
    }

    @Override
    public String deleteByLunchIdAndPersonId(String lunchId, Integer personId)
    {
        if(lunchId == null || personId == null) {
            return ("Deleted failed");
        }
        else{
            cosRepository.deleteByLunchIdAndPersonId(lunchId, personId);
            return ("Lunch deleted succesfully");
        }
    }

    @Override
    public String deleteBySnackIdAndPersonId(String snackId, Integer personId)
    {
        if(snackId == null || personId == null) {
            return ("Deleted failed");
        }
        else{
            cosRepository.deleteBySnackIdAndPersonId(snackId, personId);
            return ("Snack deleted succesfully");
        }
    }

    @Override
    @Transactional
    public String deleteByIdAndPersonId(Integer id, Integer personId)
    {
        if(id == null || personId == null) {
            return ("Deleted failed");
        }
        else{
            cosRepository.deleteByIdAndPersonId(id, personId);
            return ("Alimentation deleted succesfully");
        }
    }
}

