package com.mycompany.pizzeriaapp.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pizzeria")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PizzeriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "address", length = 70)
    String address;

   @OneToMany
   @JoinColumn(name = "pizzeria_id")
   Set<WorkerEntity> workerEntities =new HashSet<>();

   @Column(name = "quantity_workers")
   Integer quantityWorkers;
}
