package com.mycompany.pizzeriaapp.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "restaurant")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "address", length = 70)
    String address;

   @OneToMany
   @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
   Set<WorkerEntity> workerEntities = new HashSet<>();

   @OneToMany
   @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
   Set<CourierEntity> courierEntities = new HashSet<>();

   @Column(name = "quantity_workers")
   Integer quantityWorkers;

   @Column(name = "orders")
   @OneToMany
   @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
   Set<OrderEntity> orders = new HashSet<>();

   public void addWorker(WorkerEntity workerEntity) {
     workerEntities.add(workerEntity);
   }
   public void addCourier(CourierEntity courierEntity) {
     courierEntities.add(courierEntity);
   }
}
