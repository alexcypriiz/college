package ru.finplatforms.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.finplatforms.college.model.Student;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Student SET firstName = ?2, lastName = ?3, middleName = ?4, birthday = ?5, nameGroup = ?6 WHERE id = ?1")
    void updateWashOption(Long id, String firstName, String lastName, String middleName, LocalDate birthday, String nameGroup);
}
