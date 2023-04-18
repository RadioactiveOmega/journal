package com.mai.journal.Controllers;

import com.mai.journal.Services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public String getAllStudents(){
        studentService.getAllStudents();
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
    public String createStudent(){
        return "newStudent";
    }

}
