package com.mycompany.pizzeriaapp.entity;


import com.mycompany.pizzeriaapp.Util.WorkerPost;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "worker")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", length = 30)
    String name;

    @Column(name = "surname", length = 30)
    String surname;

    @Column(name = "post", length = 15)
    @Enumerated(EnumType.STRING)
    WorkerPost workerPost;
}
