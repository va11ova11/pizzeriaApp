package com.mycompany.pizzeriaapp.repository;

import com.mycompany.pizzeriaapp.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
