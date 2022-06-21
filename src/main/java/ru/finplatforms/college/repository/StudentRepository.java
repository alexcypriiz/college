package ru.finplatforms.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.finplatforms.college.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
