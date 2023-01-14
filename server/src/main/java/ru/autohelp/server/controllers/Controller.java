package ru.autohelp.server.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@Tag(name = "Main Controller", description = "The main controller")
@RestController
public class Controller {

    @GetMapping("/general")
    public String sayHello(){
        return "Hello!";
    }

    @GetMapping("/about")
    public String getAbout(){
        return "redirect:/about";
    }

    @GetMapping("/services")
    public String getServices(){
        return "redirect:/services";
    }

    @GetMapping("/contacts")
    public String getContacts(){
        return "redirect:/contacts";
    }

    @GetMapping("/gallery")
    public String getGallery(){
        return "redirect:/gallery";
    }

    @GetMapping("/feedback")
    public String getFeedback(){
        return "redirect:/feedback";
    }

    @GetMapping("/auth")
    public String login(){
        return "redirect:/login";
    }
}
