package ru.autohelp.server.controllers;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.autohelp.server.models.Client;

import java.lang.ref.Cleaner;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private final SessionFactory factory;

    private Session session;

    public ClientController() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();
        session = factory.getCurrentSession();
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        session.beginTransaction();
        Client client = session.get(Client.class, id);
        model.addAttribute("client", client);
        session.getTransaction().commit();
        return "clients/show";
    }

    @GetMapping("/new")
    public String newClient(int id, Model model){
        //Client client = ;
        return "redirect:/clients";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        return "redirect:/clients";
    }

    @GetMapping("/{id}/edit")
    public String edit(int id, Model model){
        return "redirect:/clients";
    }
}
