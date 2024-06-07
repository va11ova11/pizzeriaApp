package com.mycompany.pizzeriaapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "courier")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String surname;

    Long kilometre;

    @OneToMany
    @JoinColumn(name = "courier_id" ,referencedColumnName = "id")
    Set<OrderEntity> orders = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="restaurant_id", nullable = false)
    @JsonIgnore
    RestaurantEntity restaurantEntity;
}
