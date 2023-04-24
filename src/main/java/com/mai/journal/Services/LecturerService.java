package com.mai.journal.Services;

import com.mai.journal.Domain.Lecturer;
import com.mai.journal.Exeptions.NotFoundExeption;
import com.mai.journal.Repos.LecturerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class LecturerService {
    private LecturerRepository lecturerRepository;

    public Iterable<Lecturer> getAllLecturers(){
        return lecturerRepository.findAll();
    }
    public Lecturer getLecturerById(long id){
        return lecturerRepository.findById(id).orElseThrow(() ->
                new NotFoundExeption("Lecturer with id " + id + " not found"));
    }

    public void save(Lecturer lecturer){
            lecturerRepository.save(lecturer);
    }
}
