package com.mycompany.pizzeriaapp.Util;

import com.mycompany.pizzeriaapp.dto.WorkerDto;
import com.mycompany.pizzeriaapp.entity.WorkerEntity;

public class WorkerMapper {



  public static WorkerEntity mapToWorkerEntity(WorkerDto workerDto) {
    return WorkerEntity.builder()
        .name(workerDto.getName())
        .surname(workerDto.getSurname())
        .workerPost(workerDto.getWorkerPost())
        .build();

  }

  public static WorkerDto mapToWorkerDto(WorkerEntity workerEntity) {
    if (workerEntity.getRestaurantEntity() != null) {
      return WorkerDto.builder()
          .id(workerEntity.getId())
          .name(workerEntity.getName())
          .surname(workerEntity.getSurname())
          .workerPost(workerEntity.getWorkerPost())
          .workingRestaurantAddress(workerEntity.getRestaurantEntity().getAddress())
          .build();
    }
    else {
      return WorkerDto.builder()
          .id(workerEntity.getId())
          .name(workerEntity.getName())
          .surname(workerEntity.getSurname())
          .workerPost(workerEntity.getWorkerPost())
          .workingRestaurantAddress("Работник не работает ни в одном ресторане")
          .build();
    }
  }
}
