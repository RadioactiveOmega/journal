package com.mai.journal.Services;

import com.mai.journal.Domain.Student;
import com.mai.journal.Exeptions.NotFoundExeption;
import com.mai.journal.Repos.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundExeption("Student with id " + id +" not found"));
    }

    public long count(){
        return studentRepository.count();
    }
    public void save(Student student){
        studentRepository.save(student);
    }
    public void save(String login, long groupId){
        Student student = new Student(login, groupId);
        studentRepository.save(student);
    }
}
