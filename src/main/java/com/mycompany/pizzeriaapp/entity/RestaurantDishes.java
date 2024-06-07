package com.mycompany.pizzeriaapp.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Duration;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "restaurant_dishes")
public class RestaurantDishes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String dishName;

    Duration timeToCock;
}
