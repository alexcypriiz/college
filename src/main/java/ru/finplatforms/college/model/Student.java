package ru.finplatforms.college.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "order_entity")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Укажите фамилию")
    @Size(min = 2, message = "Минимальное количество букв в фамилии 2")
    private String lastName;

    @NotEmpty(message = "Укажите имя")
    @Size(min = 2, message = "Минимальное количество букв в имени 2")
    private String firstName;

    @NotEmpty(message = "Укажите отчество")
    @Size(min = 2, message = "Минимальное количество букв в отчестве 2")
    private String middleName;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthday;

    @NotEmpty(message = "Укажите название группы")
    @Size(min = 2, message = "Минимальное количество букв в названии группы 5")
    private String nameGroup;
}
