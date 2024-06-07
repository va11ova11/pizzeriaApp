package com.mycompany.pizzeriaapp.controller;

import com.mycompany.pizzeriaapp.dto.CourierDto;
import com.mycompany.pizzeriaapp.service.workers.CourierService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/couriers")
@RequiredArgsConstructor
public class CourierController {


  private final CourierService courierService;

  @PostMapping
  public CourierDto addCourier(@Valid @RequestBody CourierDto courierDto) {
    return courierService.addCourier(courierDto);
  }

  @GetMapping("/{id}")
  public CourierDto getCourierById(@PathVariable @NotNull Long id) {
    return courierService.getCourierById(id);
  }

  @GetMapping("/search")
  public CourierDto getCourierByNameAndSurname(@RequestParam @NotNull String name,
      @RequestParam @NotNull String surname) {
    return courierService.getCourierByNameAndSurname(name, surname);
  }

  @GetMapping
  public List<CourierDto> getCouriers() {
    return courierService.getCouriers();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCourierById(@PathVariable Long id) {
    return courierService.deleteCourier(id);
  }
}
