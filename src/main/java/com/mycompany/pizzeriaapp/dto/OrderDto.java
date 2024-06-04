package com.mycompany.pizzeriaapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.pizzeriaapp.entity.OrderPosition;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@Data
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {

  @JsonIgnore
  Long id;

  @JsonIgnore
  LocalDateTime timeOrderAcceptance;

  LocalDateTime timeOrderCreated;

  List<OrderPosition> orderPositions;

  String paymentType;
}
