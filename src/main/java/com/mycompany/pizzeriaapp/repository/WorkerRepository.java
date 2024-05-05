package com.mycompany.pizzeriaapp.repository;

import com.mycompany.pizzeriaapp.entity.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {
    WorkerEntity getWorkerEntitiesByNameAndSurname(String name, String surname);
    Boolean existsByNameAndSurname(String name, String surname);
}
