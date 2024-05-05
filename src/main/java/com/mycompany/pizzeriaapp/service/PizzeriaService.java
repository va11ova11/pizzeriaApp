package com.mycompany.pizzeriaapp.service;

import com.mycompany.pizzeriaapp.dto.PizzeriaDto;
import com.mycompany.pizzeriaapp.entity.PizzeriaEntity;
import com.mycompany.pizzeriaapp.exception.NotFoundException;
import com.mycompany.pizzeriaapp.repository.PizzeriaRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mycompany.pizzeriaapp.Util.dtoMaker.makePizzeriaDto;
import static com.mycompany.pizzeriaapp.Util.dtoMaker.makePizzeriaEntity;

@Service
public class PizzeriaService {

    private final PizzeriaRepositories pizzeriaRepositories;

    public PizzeriaService(PizzeriaRepositories pizzeriaRepositories) {
        this.pizzeriaRepositories = pizzeriaRepositories;
    }


    public PizzeriaDto addPizzeria(PizzeriaDto pizzeriaDto) {
        PizzeriaEntity newPizzeriaEntity = makePizzeriaEntity(pizzeriaDto);
        pizzeriaRepositories.save(newPizzeriaEntity);
        return pizzeriaDto;
    }

    public List<PizzeriaDto> getAllPizzerias() {
        List<PizzeriaDto> pizzerias = new ArrayList<>();
        for(PizzeriaEntity pe : pizzeriaRepositories.findAll()) {
            pizzerias.add(makePizzeriaDto(pe));
        }
        return pizzerias;
    }

    public PizzeriaDto getPizzeriaById(Long id) {
        if(pizzeriaRepositories.existsById(id)) {
            return makePizzeriaDto(pizzeriaRepositories.findById(id).get());
        } else throw new NotFoundException("Такой пиццерии не существует");
    }

    public Boolean deleteById(Long id) {
        if(pizzeriaRepositories.existsById(id)) {
            pizzeriaRepositories.deleteById(id);
            return true;
        } else return false;
    }
}
