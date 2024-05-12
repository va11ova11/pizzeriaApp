package com.mycompany.pizzeriaapp.repository;

import com.mycompany.pizzeriaapp.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepositories extends JpaRepository<RestaurantEntity, Long> {

}
