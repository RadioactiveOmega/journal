package com.mai.journal.Controllers;

import com.mai.journal.Domain.Lecturer;
import com.mai.journal.Repos.LecturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lecturers")
@AllArgsConstructor
public class LecturerController {

    private LecturerRepository lecturerRepository;

    @GetMapping
    public String index(Model model){
        Iterable<Lecturer> lecturers =  lecturerRepository.findAll();
        model.addAttribute("lecturers", lecturers);
        return "lecturers";
    }

    @GetMapping("/newLecturer")
    public String newLecturer(@ModelAttribute Lecturer lecturer){
        return "newLecturer";
    }

    @PostMapping
    public String create(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam(required = false) String patronymic){

        Lecturer lecturer = new Lecturer(name, surname, patronymic);
        lecturerRepository.save(lecturer);
        return "redirect:/lecturers";
    }
}
