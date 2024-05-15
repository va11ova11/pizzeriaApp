package com.mycompany.pizzeriaapp.dto;

import com.mycompany.pizzeriaapp.entity.CourierEntity;
import com.mycompany.pizzeriaapp.entity.WorkerEntity;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantDto {

    Long id;
    String address;
    Integer quantityWorkers;
    Set<WorkerEntity> workerEntities;
    Set<CourierEntity> courierEntities;
}
