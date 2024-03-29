package ru.autohelp.server.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;

@Schema(description = "Client's car")
@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Schema(example = "WBA47110007817985")
    @NotEmpty(message = "VIN-номер автомобиля не должен быть пустым")
    @Size(min = 2, max = 100, message = "VIN-номер автомобиля должен быть от 2 до 100 символов длиной")
    @Column(name = "vin")
    private String vin;

    @NotEmpty(message = "Марка не должна быть пустой")
    @Size(min = 2, max = 100, message = "Марка должна быть от 2 до 100 символов длиной")
    @Column(name = "brand")
    private String brand;

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


    @Schema(example = "K323AO")
    @NotEmpty(message = "Номер не должен быть пустой")
    @Size(min = 8, max = 9, message = "Номер должен быть от 8 до 9 символов длиной")
    @Column(name = "number")
    private String number;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private Client client;

    public Car() {

    }

    public Car(String vin, String model, int year, Client client, int mileage, String number) {
        this.vin = vin;
        this.model = model;
        this.year = year;
        this.client = client;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

//    public Client getClient() {
//        return client;
//    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Car:" + "\n" +
                "id = " + id + ",\n" +
                "vin = " + vin + ",\n" +
                "brand = " + brand + ",\n" +
                "model = " + model + ",\n" +
                "year = " + year + ",\n" +
                "mileage = " + mileage + ",\n" +
                "number = " + number;
    }
}
