package com.mycompany.pizzeriaapp.Util;

import com.mycompany.pizzeriaapp.dto.RestaurantDto;
import com.mycompany.pizzeriaapp.entity.RestaurantEntity;

public class RestaurantMapper {

    public static RestaurantDto mapToRestaurantDto(RestaurantEntity restaurantEntity) {
        return  RestaurantDto.builder()
                .id(restaurantEntity.getId())
                .address(restaurantEntity.getAddress())
                .quantityWorkers(restaurantEntity.getQuantityWorkers())
                .workerEntities(restaurantEntity.getWorkerEntities())
                .courierEntities(restaurantEntity.getCourierEntities())
                .build();
    }



    public static RestaurantEntity mapToRestaurantEntity(RestaurantDto restaurantDto) {
        return RestaurantEntity.builder()
                .address(restaurantDto.getAddress())
                .quantityWorkers(restaurantDto.getQuantityWorkers())
                .workerEntities(restaurantDto.getWorkerEntities())
                .courierEntities(restaurantDto.getCourierEntities())
                .build();
    }
}
