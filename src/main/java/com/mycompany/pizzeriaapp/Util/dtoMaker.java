package com.mycompany.pizzeriaapp.Util;

import com.mycompany.pizzeriaapp.dto.PizzeriaDto;
import com.mycompany.pizzeriaapp.entity.PizzeriaEntity;

public class dtoMaker {

    public static PizzeriaDto makePizzeriaDto(PizzeriaEntity pizzeriaEntity) {
        return  PizzeriaDto.builder()
                .id(pizzeriaEntity.getId())
                .address(pizzeriaEntity.getAddress())
                .quantityWorkers(pizzeriaEntity.getQuantityWorkers())
                .build();
    }
}
