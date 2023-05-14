package com.mai.journal.Controllers;

import com.mai.journal.Domain.Group;
import com.mai.journal.Services.GroupService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/chief")
@AllArgsConstructor
public class HeadOfDepartmentController {
    private GroupService groupService;

    //TODO Представления
    @GetMapping
    public String index(){
        return "chief";
    }

    @GetMapping( "/registerGroup")
    public String registerGroup(){
        return "registerGroup";
    }
    @PostMapping("/registerGroup")
    public String createGroup(
            @RequestParam("name") String name,
            @RequestParam("count") int count,
            Model model
    ){
        model.addAttribute("accesses", groupService.registerGroup(name, count));
        return "registerGroup";
    }
}
