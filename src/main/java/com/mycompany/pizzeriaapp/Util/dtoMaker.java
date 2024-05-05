package com.mycompany.pizzeriaapp.Util;

import com.mycompany.pizzeriaapp.dto.PizzeriaDto;
import com.mycompany.pizzeriaapp.dto.WorkerDto;
import com.mycompany.pizzeriaapp.entity.PizzeriaEntity;
import com.mycompany.pizzeriaapp.entity.WorkerEntity;
import com.mycompany.pizzeriaapp.service.PizzeriaService;

public class dtoMaker {

    public static PizzeriaDto makePizzeriaDto(PizzeriaEntity pizzeriaEntity) {
        return  PizzeriaDto.builder()
                .id(pizzeriaEntity.getId())
                .address(pizzeriaEntity.getAddress())
                .quantityWorkers(pizzeriaEntity.getQuantityWorkers())
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

    public static PizzeriaEntity makePizzeriaEntity(PizzeriaDto pizzeriaDto) {
        return PizzeriaEntity.builder()
                .address(pizzeriaDto.getAddress())
                .quantityWorkers(pizzeriaDto.getQuantityWorkers())
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
