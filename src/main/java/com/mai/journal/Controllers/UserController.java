package com.mai.journal.Controllers;

import com.mai.journal.Domain.User;
import com.mai.journal.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/registration")
    public String registration(@ModelAttribute User usr){
        return "registration";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @PostMapping("/registration")
    public String registerUser(@RequestParam String login,
                               @RequestParam String password,
                               Model model){
        if(!userService.createUser(login, password)){
            model.addAttribute("error", "Ошибка при создании пользователя!");
            return "registration";
        }
        return "redirect:/success";
    }
}
