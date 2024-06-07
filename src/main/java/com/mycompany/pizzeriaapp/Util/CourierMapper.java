package com.mycompany.pizzeriaapp.Util;

import com.mycompany.pizzeriaapp.dto.CourierDto;
import com.mycompany.pizzeriaapp.entity.CourierEntity;
import java.util.Locale.Builder;

public class CourierMapper {

  public static CourierEntity mapToCourierEntity(CourierDto courierDto) {
    return CourierEntity.builder()
        .id(courierDto.getId())
        .name(courierDto.getName())
        .surname(courierDto.getSurname())
        .kilometre(courierDto.getKilometre())
        .build();
  }

  public static CourierDto mapToCourierDto(CourierEntity courierEntity) {
    return CourierDto.builder()
        .id(courierEntity.getId())
        .name(courierEntity.getName())
        .surname(courierEntity.getSurname())
        .kilometre(courierEntity.getKilometre())
        .build();
  }
}
