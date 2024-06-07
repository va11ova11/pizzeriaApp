package com.mycompany.pizzeriaapp.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryOrderDto extends OrderDto {

  @Size(max = 200, message = "Слишком длинный комментарий")
  String comment;

  @JsonIgnore
  @FutureOrPresent
  @DateTimeFormat(pattern = "hh:mm dd.MM.yyyy")
  LocalDateTime timeToDelivery;

  ClientDto clientDto;
}
