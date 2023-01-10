USE autohelp;

DROP TABLE car;

SET FOREIGN_KEY_CHECKS=0;

ALTER TABLE autohelp.car DROP foreign key owner_id;

CREATE TABLE autohelp.car(
	id int NOT NULL AUTO_INCREMENT,
	vin varchar(150),
    brand varchar(150),
    model varchar(150),
	year int,
    mileage int,
    number varchar(150),
    PRIMARY KEY (id)
    -- FOREIGN KEY (client_id) REFERENCES autohelp.client(id) ON DELETE CASCADE
);

INSERT INTO autohelp.car VALUES(5, 'WBA47110007817985', 'Reanult', 'Logan', 2012, 200, 'K323AO', 1);
INSERT INTO autohelp.car VALUES(6, 'WAUZZZ44ZEN096063', 'BMW', 'M5 Competition', 2020, 330, 'B666BB', 2);
INSERT INTO autohelp.car VALUES(7, 'WVWDB4505LK234567', 'LADA', 'Priora', 2011, 510, 'A295YO', 3);
INSERT INTO autohelp.car VALUES(8, 'ZFA22300005556777', 'Audi', 'Q7', 2014, 340, 'O378HP', 4);
INSERT INTO autohelp.car VALUES(9, 'WVGZZZCAZJC552859', 'Skoda', 'Octavia', 2018, 101, 'P790MA', 542996008);