package com.mycompany.pizzeriaapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.pizzeriaapp.entity.CourierEntity;
import com.mycompany.pizzeriaapp.entity.WorkerEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantDto {

    Long id;

    @NotBlank(message = "Отсутствует адрес ресторана")
    @Size(max = 50, message = "Слишком длинный адрес")
    String address;
    @Max(value = 10, message = "Количество работников не может быть больше 10")
    Integer quantityWorkers;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Set<WorkerEntity> workerEntities;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Set<CourierEntity> courierEntities;
}
