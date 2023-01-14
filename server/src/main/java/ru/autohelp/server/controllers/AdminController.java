package ru.autohelp.server.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Admin Controller", description = "Controller with Admin access")
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping()
    public String adminPage() {
        return "admin/page";
    }

    @GetMapping("/auth")
    public String reg() {
        return "auth/login";
    }
}
