package ru.autohelp.server2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getInfoForAll(){
        return "view_for_all";
    }

    @GetMapping("/user_info")
    public String getInfoOnlyForClient(){
        return "view_for_clients";
    }

    @GetMapping("/admin_info")
    public String getInfoOnlyForAdmin(){
        return "view_for_admin";
    }
}
