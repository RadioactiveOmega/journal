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
    public String registerGroup(
            Model model){
        System.out.println("Пришло");

        return "registerGroup";
    }
    @PostMapping("/registerGroup")
    public String createGroup(
            @RequestParam("name") String name,
            @RequestParam("count") int count,
            Model model
    ){
        String[] str = {"123", "456"};
        model.addAttribute("accesses", groupService.registerGroup(name, count));


        System.out.println("lol");
        return "registerGroup";
    }
}
