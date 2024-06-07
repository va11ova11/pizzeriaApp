package com.mycompany.pizzeriaapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.pizzeriaapp.entity.OrderPositionEntity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public class OrderDto {

  @JsonIgnore
  Long id;

  //@FutureOrPresent(message = "Время принятия заказа не может быть в прошлом")
  //@JsonFormat(pattern = "hh:mm dd.MM.yyyy")
  @DateTimeFormat(pattern = "hh:mm dd.MM.yyyy")
  LocalDateTime timeOrderAcceptance = LocalDateTime.now();

  @PastOrPresent(message = "Время приготовления не может быть в прошлом")
  @JsonFormat(pattern = "hh:mm dd.MM.yyyy")
  LocalDateTime timeOrderCreated;

  @NotNull(message = "Заказ не может быть пустым")
  List<OrderPositionEntity> orderPositionEntities;

  @Size(max = 30)
  String paymentType;

  Duration timeToCook;

}
