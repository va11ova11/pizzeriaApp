package com.mycompany.pizzeriaapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDto {

    Long id;

    @Size(max = 20)
    String clientPhoneNumber;

    String name;

    @Size(max = 50, message = "Слишком длинный адресс")
    String address;

    @Positive
    @Max(value = 50, message = "Слишком много персон")
    Integer numberOfCutlery;
}
