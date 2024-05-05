package com.mycompany.pizzeriaapp.repository;

import com.mycompany.pizzeriaapp.entity.PizzeriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzeriaRepositories extends JpaRepository<PizzeriaEntity, Long> {
}
