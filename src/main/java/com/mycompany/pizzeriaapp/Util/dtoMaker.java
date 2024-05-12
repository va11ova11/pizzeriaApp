package com.mycompany.pizzeriaapp.Util;

import com.mycompany.pizzeriaapp.dto.RestaurantDto;
import com.mycompany.pizzeriaapp.dto.WorkerDto;
import com.mycompany.pizzeriaapp.entity.RestaurantEntity;
import com.mycompany.pizzeriaapp.entity.WorkerEntity;

public class dtoMaker {

    public static RestaurantDto makeRestaurantDto(RestaurantEntity restaurantEntity) {
        return  RestaurantDto.builder()
                .id(restaurantEntity.getId())
                .address(restaurantEntity.getAddress())
                .quantityWorkers(restaurantEntity.getQuantityWorkers())
                .build();
    }

    public static WorkerDto makeWorkerDto(WorkerEntity workerEntity) {
        return WorkerDto.builder()
                .id(workerEntity.getId())
                .name(workerEntity.getName())
                .surname(workerEntity.getSurname())
                .workerPost(workerEntity.getWorkerPost())
                .build();
    }

    public static RestaurantEntity makeRestaurantEntity(RestaurantDto restaurantDto) {
        return RestaurantEntity.builder()
                .address(restaurantDto.getAddress())
                .quantityWorkers(restaurantDto.getQuantityWorkers())
                .build();
    }

    public static WorkerEntity makeWorkerEntity(WorkerDto workerDto) {
        return WorkerEntity.builder()
                .name(workerDto.getName())
                .surname(workerDto.getSurname())
                .workerPost(workerDto.getWorkerPost())
                .build();

    }
}
