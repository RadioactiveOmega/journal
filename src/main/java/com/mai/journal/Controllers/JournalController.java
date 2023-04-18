package com.mai.journal.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/journals")
public class JournalController {

    @GetMapping("/")
    public String journals(){
        return null;
    }

    @GetMapping("/{group}")
    public String getGroupJournal(@PathVariable String group){
        return null;
    }


    @PostMapping("/{group}")
    public String saveGroupJournal(@PathVariable String group){
        return null;
    }
}