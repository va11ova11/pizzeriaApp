package com.mycompany.pizzeriaapp.entity;


import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@Entity
@Inheritance
@Table(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "time_order_acceptance")
  @DateTimeFormat(pattern = "hh:mm dd.MM.yyyy")
  LocalDateTime timeOrderAcceptance = LocalDateTime.now();

  @Column(name = "time_order_created")
  LocalDateTime timeOrderCreated;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "order_id", referencedColumnName = "id")
  List<OrderPositionEntity> orderPositionEntities;

  @Column(name = "payment_type")
  String paymentType;

  @Column(name = "time_to_cook")
  Duration timeToCook;
}
