package com.mycompany.pizzeriaapp.controller;

import com.mycompany.pizzeriaapp.dto.CourierDto;
import com.mycompany.pizzeriaapp.service.workers.CourierService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/couriers")
public class CourierController {


  private final CourierService courierService;

  public CourierController(CourierService courierService) {
    this.courierService = courierService;
  }

  @PostMapping
  public ResponseEntity<CourierDto> addCourier(@Valid @RequestBody CourierDto courierDto) {
    CourierDto savedCourier = courierService.addCourier(courierDto);
    return new ResponseEntity<>(savedCourier, HttpStatus.OK);
  }


  @GetMapping("/{id}")
  public ResponseEntity<CourierDto> getCourierById(@PathVariable Long id) {
      return new ResponseEntity<>(courierService.getCourierById(id), HttpStatus.OK);
  }

  @GetMapping("/search")
  public ResponseEntity<CourierDto> getCourierByNameAndSurname(@RequestParam String name,
                                                               @RequestParam String surname) {
    return new ResponseEntity<>(courierService.getCourierByNameAndSurname(name, surname), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<CourierDto>> getCouriers() {
      return new ResponseEntity<>(courierService.getCouriers(), HttpStatus.OK);
  }
}
