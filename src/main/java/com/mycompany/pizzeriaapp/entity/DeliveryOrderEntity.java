package com.mycompany.pizzeriaapp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public class DeliveryOrderEntity extends OrderEntity{

  @Column(name = "comment")
  String comment;

  @Column(name = "time_to_delivery")
  LocalDateTime timeToDelivery;

  @OneToOne(cascade = CascadeType.ALL)
  ClientEntity clientEntity;
}
