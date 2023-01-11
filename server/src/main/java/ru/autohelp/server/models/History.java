package ru.autohelp.server.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Table(name = "history")
public class History {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "works")
    private String works;

    @Column(name = "date")
    private String date;

    @OneToOne
    private Client client;
}
