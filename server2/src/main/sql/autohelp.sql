CREATE DATABASE autohelp;
USE autohelp;

CREATE TABLE IF NOT EXISTS client
(
    id integer NOT NULL AUTO_INCREMENT,
    full_name varchar(255) NOT NULL,
    contact varchar(255) NOT NULL,
    car text,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS car
(
    id integer NOT NULL AUTO_INCREMENT,
    vin varchar(255) NOT NULL,
    model varchar(255) NOT NULL,
    year int NOT NULL,
    mileage int NOT NULL,
    number varchar(255) NOT NULL,
    client_id int,
     PRIMARY KEY (id),
     FOREIGN KEY (client_id) REFERENCES client(id)
);

ALTER TABLE client ADD COLUMN role varchar(100) NOT NULL default 'user';

INSERT INTO client (full_name, contact, car)
VALUES
	('Vasya', '88005553535', 'Toyota'),
	('Petya', '85554443333', 'Mercedes');
    
INSERT INTO client (full_name, contact, car, role) VALUE ('Oleg', 'Ivanov', 'BMW', 'admin');