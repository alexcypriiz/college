package ru.finplatforms.college.service;

import org.springframework.stereotype.Service;
import ru.finplatforms.college.model.Student;
import ru.finplatforms.college.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    final
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.getOne(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
