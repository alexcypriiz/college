package ru.finplatforms.college.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.finplatforms.college.model.Student;
import ru.finplatforms.college.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/college/students")
public class StudentController {
    final
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public String findAll(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/view";
    }

    @GetMapping("/create")
    public String createStudentForm(Model model) {
        model.addAttribute("studentForm", new Student());
        return "student/create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("studentForm") @Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student/create";
        }
        studentService.saveStudent(student);
        return "redirect:/college/students";
    }

    @GetMapping("/update/{id}")
    public String updateStudentForm(@PathVariable("id") Long id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student/update";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "student/update";
        }
        studentService.updateStudent(student);
        return "redirect:/college/students";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        studentService.delete(id);
        return "redirect:/college/students";
    }
}
