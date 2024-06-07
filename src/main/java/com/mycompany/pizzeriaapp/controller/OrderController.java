package com.mycompany.pizzeriaapp.controller;


import com.mycompany.pizzeriaapp.dto.DeliveryOrderDto;
import com.mycompany.pizzeriaapp.service.delivery.DeliveryOrderService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

  private final DeliveryOrderService deliveryOrderService;

  @PostMapping("/delivery-order")
  @Operation(description = "создание заказа")
  public DeliveryOrderDto makeOrderByDelivery(@RequestBody @Valid DeliveryOrderDto deliveryOrder) {
    return deliveryOrderService.createDeliveryOrder(deliveryOrder);
  }
}
