package com.mycompany.pizzeriaapp.repository;

import com.mycompany.pizzeriaapp.entity.OrderPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPositionRepository extends JpaRepository<OrderPositionEntity, Long> {
}
