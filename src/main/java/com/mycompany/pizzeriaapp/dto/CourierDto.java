package com.mycompany.pizzeriaapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourierDto {

    Long id;

    @NotBlank(message = "Имя ряботника не задано")
    @Size(max = 15, message = "Слишком длинное имя")
    String name;

    @NotBlank(message = "Фамилия работника не задана")
    @Size(max = 15, message = "Слишком длинная фамилия")
    String surname;

    Long restaurantId;

    @PositiveOrZero(message = "Пробег не может быть отрицательным")
    @Max(value = 300, message = "Пробег не может быть больше 300 киллометров")
    Long kilometre;
}
