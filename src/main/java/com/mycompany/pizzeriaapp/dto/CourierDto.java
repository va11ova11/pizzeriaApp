package com.mycompany.pizzeriaapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourierDto {

    Long id;

    @NotBlank
    String name;

    @NotBlank
    String surname;

    Long restaurantId;

    @Max(300)
    Long kilometre;
}
