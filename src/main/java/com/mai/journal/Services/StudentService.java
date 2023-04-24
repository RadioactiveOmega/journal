package com.mai.journal.Services;

import com.mai.journal.Domain.Student;
import com.mai.journal.Exeptions.NotFoundExeption;
import com.mai.journal.Repos.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

    StudentRepository studentRepository;
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundExeption("Student with id " + id +" not found"));
    }
}
