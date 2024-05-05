package com.mycompany.pizzeriaapp.service;

import com.mycompany.pizzeriaapp.dto.PizzeriaDto;
import com.mycompany.pizzeriaapp.entity.PizzeriaEntity;
import com.mycompany.pizzeriaapp.repository.PizzeriaRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mycompany.pizzeriaapp.Util.dtoMaker.makePizzeriaDto;

@Service
public class PizzeriaService {

    private final PizzeriaRepositories pizzeriaRepositories;

    public PizzeriaService(PizzeriaRepositories pizzeriaRepositories) {
        this.pizzeriaRepositories = pizzeriaRepositories;
    }


    public PizzeriaDto addPizzeria(PizzeriaDto newPizzeria) {
        PizzeriaEntity newPizzeriaEntity = new PizzeriaEntity();
        newPizzeriaEntity.setAddress(newPizzeria.getAddress());
        newPizzeriaEntity.setQuantityWorkers(newPizzeria.getQuantityWorkers());
        pizzeriaRepositories.save(newPizzeriaEntity);
        return newPizzeria;
    }

    public List<PizzeriaDto> getAllPizzerias() {
        List<PizzeriaDto> pizzerias = new ArrayList<>();
        for(PizzeriaEntity pe : pizzeriaRepositories.findAll()) {
            pizzerias.add(makePizzeriaDto(pe));
        }
        return pizzerias;
    }



}
