package com.mycompany.pizzeriaapp.dto;

import com.mycompany.pizzeriaapp.Util.WorkerPost;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WorkerDto {

    Long id;

    @NotBlank
    String name;

    @NotBlank
    String surname;

    @NotNull
    WorkerPost workerPost;
}
