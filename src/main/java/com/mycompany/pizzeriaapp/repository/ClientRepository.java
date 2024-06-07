package com.mycompany.pizzeriaapp.repository;

import com.mycompany.pizzeriaapp.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
