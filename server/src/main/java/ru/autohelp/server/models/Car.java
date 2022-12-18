package ru.autohelp.server.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "VIN-номер автомобиля не должен быть пустым")
    @Size(min = 2, max = 100, message = "VIN-номер автомобиля должен быть от 2 до 100 символов длиной")
    @Column(name = "vin")
    private String vin;

    @NotEmpty(message = "Модель не должна быть пустой")
    @Size(min = 2, max = 100, message = "Модель должна быть от 2 до 100 символов длиной")
    @Column(name = "model")
    private String model;

    @Min(value = 1800, message = "Год должен быть больше, чем 1800")
    @Column(name = "year")
    private int year;

    @Min(value = 0, message = "Пробег должен быть неотрицательным")
    @Column(name = "mileage")
    private int mileage;

    @NotEmpty(message = "Номер не должен быть пустой")
    @Size(min = 8, max = 9, message = "Номер должен быть от 8 до 9 символов длиной")
    @Column(name = "number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @NotBlank
    private Client owner;

    public Car() {

    }

    public Car(String vin, String model, int year, Client owner, int mileage, String number) {
        this.vin = vin;
        this.model = model;
        this.year = year;
        this.owner = owner;
        this.mileage = mileage;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
}
