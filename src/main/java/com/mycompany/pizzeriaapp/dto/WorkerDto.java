package com.mycompany.pizzeriaapp.dto;

import com.mycompany.pizzeriaapp.Util.WorkerPost;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WorkerDto {

    Long id;
    String name;
    String surname;
    WorkerPost workerPost;
}
