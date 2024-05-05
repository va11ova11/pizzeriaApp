package com.mycompany.pizzeriaapp.controller;

import com.mycompany.pizzeriaapp.dto.PizzeriaDto;
import com.mycompany.pizzeriaapp.service.PizzeriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PizzeriaController {

    private final PizzeriaService pizzeriaService;

    public PizzeriaController(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    @PostMapping("/pizzeria")
    public PizzeriaDto addPizzeria(@RequestBody PizzeriaDto pizzeriaDto) {
        return pizzeriaService.addPizzeria(pizzeriaDto);
    }

    @GetMapping("/pizzeria")
    public List<PizzeriaDto> getAllPizzerias() {
        return pizzeriaService.getAllPizzerias();
    }
}
