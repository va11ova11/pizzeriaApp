package com.mycompany.pizzeriaapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.pizzeriaapp.Util.WorkerPost;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WorkerDto {

    Long id;

    @NotBlank(message = "Имя работника не задано")
    @Size(max = 15, message = "Слишком длинное имя")
    String name;

    @NotBlank(message = "Фамилия работника не задана")
    @Size(max = 15, message = "Слишком длинная фамилия")
    String surname;

    @NotNull(message = "Должность работника не задана")
    WorkerPost workerPost;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    String workingRestaurantAddress;
}
