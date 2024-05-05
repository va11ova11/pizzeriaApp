package com.mycompany.pizzeriaapp.controller;

import com.mycompany.pizzeriaapp.dto.PizzeriaDto;
import com.mycompany.pizzeriaapp.service.PizzeriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pizzeria")
public class PizzeriaController {

    private final PizzeriaService pizzeriaService;

    public PizzeriaController(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    @PostMapping
    public PizzeriaDto addPizzeria(@RequestBody PizzeriaDto pizzeriaDto) {
        return pizzeriaService.addPizzeria(pizzeriaDto);
    }

    @GetMapping
    public List<PizzeriaDto> getAllPizzerias() {
        return pizzeriaService.getAllPizzerias();
    }

    @GetMapping("/{id}")
    public PizzeriaDto getPizzeriaById(@PathVariable Long id) {
        return pizzeriaService.getPizzeriaById(id);
    }

    @DeleteMapping("/{id}")
    public Boolean deletePizzeriaById(@PathVariable Long id) {
        return pizzeriaService.deleteById(id);
    }
}
