package com.mycompany.pizzeriaapp.dto;

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
}
