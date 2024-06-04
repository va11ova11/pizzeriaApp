package com.mycompany.pizzeriaapp.controller;


import com.mycompany.pizzeriaapp.dto.DeliveryOrderDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @PostMapping("/delivery-order")
  public DeliveryOrderDto makeOrderByDelivery(@RequestBody DeliveryOrderDto deliveryOrder) {
    return null;
  }



}
