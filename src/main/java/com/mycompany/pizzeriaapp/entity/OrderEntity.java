package com.mycompany.pizzeriaapp.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
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

  @OneToMany
  @JoinColumn(name = "order_id", referencedColumnName = "id")
  List<OrderPosition> orderPositions = new ArrayList<>();

  @Column(name = "payment_type")
  String paymentType;
}
