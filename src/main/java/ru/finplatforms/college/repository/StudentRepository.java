package ru.finplatforms.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.finplatforms.college.model.Student;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE student_entity SET first_name_s = :firstName, last_name_s = :lastName, middle_name_s = :middleName, birthday_s = :birthday, name_group_s = :nameGroup WHERE student_id = :id", nativeQuery = true)
    void updateParamStudent(@Param("id") Long id, @Param("firstName") String firstName,
                            @Param("lastName") String lastName, @Param("middleName") String middleName,
                            @Param("birthday") Date birthday, @Param("nameGroup") String nameGroup);
}
