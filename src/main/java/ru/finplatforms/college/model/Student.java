package ru.finplatforms.college.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "student_entity")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @NotEmpty(message = "Укажите фамилию")
    @Size(min = 2, message = "Минимальное количество букв в фамилии 2")
    @Column(name = "last_name_s")
    private String lastName;

    @NotEmpty(message = "Укажите имя")
    @Size(min = 2, message = "Минимальное количество букв в имени 2")
    @Column(name = "first_name_s")
    private String firstName;

    @NotEmpty(message = "Укажите отчество")
    @Size(min = 2, message = "Минимальное количество букв в отчестве 2")
    @Column(name = "middle_name_s")
    private String middleName;

    @Column(name = "birthday_s", columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NotEmpty(message = "Укажите название группы")
    @Size(min = 2, message = "Минимальное количество букв в названии группы 2")
    @Column(name = "name_group_s")
    private String nameGroup;

}
