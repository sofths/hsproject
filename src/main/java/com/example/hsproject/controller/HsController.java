package com.example.hsproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HsController {
    @GetMapping("/hi")
    public String Hi(Model model){
        model.addAttribute("username","JHs");
        return "greetings";// templates/greetings.mustache -> 브라우저로 전송!
    }
    @GetMapping("/bye")
    public String Bye(Model model){
        model.addAttribute("name","JHs");
        return "goodbye";
    }
}
