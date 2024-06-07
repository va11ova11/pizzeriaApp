package com.mycompany.pizzeriaapp.repository;

import com.mycompany.pizzeriaapp.entity.CourierEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends JpaRepository<CourierEntity, Long> {
  Optional<CourierEntity> getCourierEntitiesByNameAndSurname(String name, String surname);
}
