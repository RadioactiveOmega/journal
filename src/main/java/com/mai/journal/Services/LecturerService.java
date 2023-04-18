package com.mai.journal.Services;

import com.mai.journal.Domain.Lecturer;
import com.mai.journal.Exeptions.NotFoundExeption;
import com.mai.journal.Repos.LecturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LecturerService {
    private LecturerRepository lecturerRepository;

    public Iterable<Lecturer> getAllLecturers(){
        return lecturerRepository.findAll();
    }
    public Lecturer getLecturerById(long id){
        return lecturerRepository.findById(id).orElseThrow(() ->
                new NotFoundExeption("Lecturer with id " + id + " not found"));
    }
}
