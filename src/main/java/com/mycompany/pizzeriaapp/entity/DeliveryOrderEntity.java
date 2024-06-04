package com.mycompany.pizzeriaapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;



@Entity
public class DeliveryOrderEntity extends OrderEntity{

  @Column(name = "client_phone_number")
  String clientPhoneNumber;
  String address;
  String comment;

  @Column(name = "people_quantity")
  Integer peopleQuantity;

  @Column(name = "time_to_delivery")
  LocalDateTime timeToDelivery;
}
