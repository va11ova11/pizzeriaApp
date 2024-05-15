package com.mycompany.pizzeriaapp.repository;

import com.mycompany.pizzeriaapp.entity.RestaurantEntity;
import com.mycompany.pizzeriaapp.entity.WorkerEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepositories extends JpaRepository<RestaurantEntity, Long> {

}
