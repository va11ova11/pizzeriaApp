package com.mycompany.pizzeriaapp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "order_position")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderPosition {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String foodName;

  Integer quantity;

  String supplement;

}
