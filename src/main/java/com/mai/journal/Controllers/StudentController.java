package com.mai.journal.Controllers;

import com.mai.journal.Domain.Student;
import com.mai.journal.Services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public String getAllStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }
    @GetMapping("/{id}")
    public String getStudentById(@PathVariable String id){
        return null;
    }
    @PostMapping("/{id}")
    public String updateStudent(@PathVariable String id){
        return null;
    }
    @GetMapping("/newStudent")
    public String createStudent(@ModelAttribute Student student){
        return "newStudent";
    }
    @PostMapping
    public String create(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam(required = false) String patronymic,
            @RequestParam long groupId) {

        Student student = new Student(name, surname, patronymic, groupId);
        studentService.save(student);
        return "redirect:/students";
    }

}
