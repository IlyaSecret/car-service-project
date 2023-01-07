package ru.autohelp.server.models;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

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
//    @Digits(message = "Телефон должен состоять только из цифр", integer = 11, fraction = 0)
    @Column(name = "contact")
    private String contact;

//    @Min(value = 1900, message = "Год рождения должен быть больше, чем 1900")
//    @Column(name = "year_of_birth")
//    private int yearOfBirth;

    @Column(name = "car")
    private String car;

    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;


    // Конструктор по умолчанию нужен для Spring
    public Client() {

    }

    public Client(String fullName, String contact, String car, String role) {
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

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", contact='" + contact + '\'' +
                ", car='" + car + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
