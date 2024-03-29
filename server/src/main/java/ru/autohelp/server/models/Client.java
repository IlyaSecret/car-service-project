package ru.autohelp.server.models;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "Car Service Client")
@Entity
@Table(name = "client")
public class Client {
    @Id
    @Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов длиной")
    @Column(name = "full_name")
    private String fullName;

    @NotEmpty(message = "Контакт не должно быть пустым")
    @Size(min = 2, max = 100, message = "Контакт должно быть от 2 до 100 символов длиной")
    @Column(name = "contact")
    private String contact;

    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;

    @Column(name = "subscribe")
    private boolean isSubscribed;

    @OneToOne
    private Car car;


    // Конструктор по умолчанию нужен для Spring
    public Client() {

    }

    public Client(String fullName, String contact, Car car, String role) {
        this.fullName = fullName;
        this.contact = contact;
        this.car = car;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    @Override
    public String toString() {
        return "Client:" + "\n" +
                "id = " + id + ",\n" +
                "fullName = " + fullName + ",\n" +
                "contact = " + contact + ",\n" +
                "role = " + role + ",\n" +
                "isSubscribed = " + isSubscribed + ",\n" +
                "car = " + car;
    }
}
