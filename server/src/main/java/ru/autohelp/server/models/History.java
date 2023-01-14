package ru.autohelp.server.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Schema(description = "Service History")
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

    @Schema(example = "xx.xx.xxxx")
    @Column(name = "date")
    private String date;

    @OneToOne
    private Client client;

    @Override
    public String toString() {
        return "\n History:" + "\n" +
                "id = " + id + ",\n" +
                "employeeName = " + employeeName + ",\n" +
                "works = " + works + ",\n" +
                "date = " + date + ",\n" +
                "client = " + client;
    }
}
