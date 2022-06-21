package ru.finplatforms.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.finplatforms.college.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
