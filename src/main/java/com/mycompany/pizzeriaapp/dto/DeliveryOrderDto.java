package com.mycompany.pizzeriaapp.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;


public class DeliveryOrderDto extends OrderDto {

  String clientPhoneNumber;
  String address;
  String comment;
  Integer peopleQuantity;
  @JsonIgnore
  LocalDateTime timeToDelivery;

}
