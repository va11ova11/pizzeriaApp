package com.mycompany.pizzeriaapp.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PizzeriaDto {

    Long id;
    String address;
    Integer quantityWorkers;
}
